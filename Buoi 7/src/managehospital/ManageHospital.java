package managehospital;

public class ManageHospital {
    private Patient patient;
    private Doctor doctor;

    public ManageHospital(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "ManageHospital{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
