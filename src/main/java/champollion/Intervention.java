package champollion;

import java.util.Date;

public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee;
    private int heureDebut;
    private UE ue;
    private TypeIntervention type;

    public Intervention(Date debut, int duree, boolean annulee, int heureDebut, UE ue, TypeIntervention type) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.ue=ue;
        this.type=type;

    }

    public UE getUe() {
        return ue;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getType() {
        return type;
    }
}
