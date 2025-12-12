package storage;


import exception.DoctorNotFoundException;
import model.Doctor;
import model.Profession;

import java.io.Serializable;

public class DoctorStorage implements Serializable {

    private Doctor[] doctors;
    private int size;
    private int id;

    public DoctorStorage() {
        doctors = new Doctor[10];
        id = 1;
    }

    public int generateId() {
        return id++;
    }

    public void addDoctor(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }
        doctors[size++] = doctor;
    }

    private void extend() {
        Doctor[] tmp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, tmp, 0, size);
        doctors = tmp;
    }

    public void searchDoctorByProfession(Profession profession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession() == profession) {
                System.out.println(doctors[i]);
                return;
            }
        }
        System.out.println("There is no doctor in this specialty.");
    }

    public void deleteDoctorById(int id) {
        if (size == -1) {
            System.out.println("There are not doctors");
            return;
        }

        int index = -1;

        for (int i = 0; i < size; i++) {
            if (doctors[i].getId() == id) {
                index = i;
                break;
            }
        }
        for (int i = index; i < size; i++) {
            doctors[i] = doctors[i + 1];
        }
        size--;
        System.out.println("Doctor deleted successfully");
    }

    public Doctor getDoctorById(int idDoctor) throws DoctorNotFoundException {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId() == idDoctor) {
                return doctors[i];
            }
        }
        throw new DoctorNotFoundException("Doctor with " + idDoctor + " id does not exist!!!");
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }
}
