package storage;


import exception.DoctorNotFoundException;
import lombok.NoArgsConstructor;
import model.Doctor;
import model.Patient;
import model.Profession;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Storage<T> implements Serializable {

    private List<T> objects = new ArrayList<>();
    private Map<String, T> map = new HashMap<>();
    private int doctorId = 1;
    private String userId;


    public int generateDoctorId() {
        return doctorId++;
    }

    public String generateUserId() {
        int count = 1;
        userId = "User" + count++;
        return userId;
    }

    public void add(T type) {
        if (type instanceof User user) {
            map.put(user.getEmail(), type);
            return;
        }
        objects.add(type);
    }

    public User getUserByEmail(String email) {
        return (User) map.get(email);
    }


    public void searchDoctorByProfession(Profession profession) {
        for (T object : objects) {
            if (object instanceof Doctor && profession.equals(((Doctor) object).getProfession())) {
                System.out.println(object);
                return;
            }
        }
        System.out.println("There is no doctor in this specialty.");
    }

    public void deleteDoctorById(int id) {
        if (!objects.isEmpty()) {
            for (T object : objects) {
                if (object instanceof Doctor && id == ((Doctor) object).getId()) {
                    objects.remove(object);
                }
            }
            System.out.println("Doctor deleted successfully");
        } else {
            System.out.println("Doctor with " + id + " id does not exist!!!");
        }

    }

    public Doctor getDoctorById(int idDoctor) throws DoctorNotFoundException {
        for (T object : objects) {
            if (object instanceof Doctor && idDoctor == ((Doctor) object).getId()) {
                return (Doctor) object;
            }
        }
        throw new DoctorNotFoundException("Doctor with " + idDoctor + " id does not exist!!!");
    }

    public void printAllDoctors() {
        for (T object : objects) {
            if (object instanceof Doctor) {
                System.out.println(object);
            }
        }
    }

    public void printPatientsByDoctor(Doctor doctor) {
        for (T object : objects) {
            if (object instanceof Patient && ((Patient) object).getDoctor().equals(doctor)) {
                System.out.println(object);
            }
        }
    }

    public void printAllPatients() {
        for (T object : objects) {
            if (object instanceof Patient) {
                System.out.println(object);
            }
        }
    }

}
