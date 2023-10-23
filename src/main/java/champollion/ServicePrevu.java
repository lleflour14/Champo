package champollion;

public class ServicePrevu {
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private UE ue;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public int getVolume(TypeIntervention type) {
        int res = 0;

        if(type.equals(TypeIntervention.TD)){
            res=getVolumeTD();
        }
        if(type.equals(TypeIntervention.TP)){
            res=getVolumeTP();
        }
        if(type.equals(TypeIntervention.CM)){
            res=getVolumeCM();
        }
        return res;
    }
}
