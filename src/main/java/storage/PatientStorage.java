package storage;

import model.Doctor;
import model.Patient;

import java.io.Serializable;

public class PatientStorage implements Serializable {

    private Patient[] patients;
    private int size;

    public PatientStorage() {
        patients = new Patient[10];
        size = 0;
    }

    public void addPatient(Patient patient) {
        if (size == patients.length) {
            extend();
        }
        patients[size++] = patient;
    }

    private void extend() {
        Patient[] tmp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, tmp, 0, size);
        patients = tmp;
    }

    public void printPatientsByDoctor(Doctor doctor) {
        if (size != -1) {
            for (int i = 0; i < size; i++) {
                if (patients[i].getDoctor().equals(doctor)) {
                    System.out.println(patients[i]);
                }
            }
        } else {
            System.out.println("No patient added !!!");
        }
    }

    public void printAllPatients() {
        if (size != -1) {
            for (int i = 0; i < size; i++) {
                System.out.println(patients[i]);
            }
        } else {
            System.out.println("No patient added !!!");
        }
    }
}
