package managehospital;

public class Patient extends Person{
    private int medicalRecordNumber;
    private String dateOfAdmission;

    public Patient(String name, int age, int medicalRecordNumber, String dateOfAdmission) {
        super(name, age);
        this.medicalRecordNumber = medicalRecordNumber;
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(int medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + getName() +
                ", age=" + getAge() +
                "medicalRecordNumber=" + medicalRecordNumber +
                ", dateOfAdmission='" + dateOfAdmission + '\'' +
                '}';
    }
}
