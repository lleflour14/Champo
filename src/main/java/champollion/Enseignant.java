package champollion;

import java.util.ArrayList;
import java.util.HashMap;

import static champollion.TypeIntervention.CM;

public class Enseignant extends Personne {


    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    private  HashMap<UE, ServicePrevu> enseignement = new HashMap<UE, ServicePrevu>();
    private ArrayList<Intervention> planification = new ArrayList<Intervention>();


    public float equivalentTD(TypeIntervention type, int volHoraire){
        float result =0F;
        if(type.equals(TypeIntervention.CM)){
            result=volHoraire*1.5F;
        }
        if(type.equals(TypeIntervention.TD)){
            result=volHoraire;
        }
        if(type.equals(TypeIntervention.TP)){
            result=volHoraire*0.75f;
        }
        return result;
    }
    public int heuresPrevues() {
        float res=0F;
        for (UE ue : enseignement.keySet()) {
            res += heuresPrevuesPourUE(ue);
        }
        return Math.round(res);
    }

    public int heuresPrevuesPourUE(UE ue) {
        float res = 0;

        ServicePrevu servprev = enseignement.get(ue);
        if (servprev != null) {
            res =  equivalentTD(TypeIntervention.CM, servprev.getVolumeCM()) + equivalentTD(TypeIntervention.TD, servprev.getVolumeTD()) + equivalentTD(TypeIntervention.TP, servprev.getVolumeTP())
            ;
        }
        return Math.round(res);
    }


    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu servprev = enseignement.get(ue);
        if (volumeCM < 0 || volumeTD < 0 || volumeTP < 0) {
            throw new IllegalArgumentException("Valeurs + ou 0");
        }

        if (servprev == null) {
            servprev = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue);
            enseignement.put(ue, servprev);
        } else {
            servprev.setVolumeCM(volumeCM + servprev.getVolumeCM());
            servprev.setVolumeTD(volumeTD + servprev.getVolumeTD());
            servprev.setVolumeTP(volumeTP + servprev.getVolumeTP());
        }
    }

    public boolean enSousService() {
        return heuresPrevues() < 192;
    }

    public void ajouteIntervention(Intervention inter){
        if (!enseignement.containsKey(inter.getUe())) {
            throw new IllegalArgumentException("cette UE ne fait pas partie des enseignements");
        }

        planification.add(inter);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        float plan = 0f;
        ServicePrevu servprev = enseignement.get(ue);
        float aPlan = servprev.getVolume(type);
        if (null == servprev) {
            return 0;
        }
            for (Intervention inter : planification) {
                if ((ue.equals(inter.getUe())) && (type.equals(inter.getType()))) {
                    plan += inter.getDuree();
                }
            }

        return Math.round(aPlan - plan);
    }
}
