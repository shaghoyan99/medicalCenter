package storage;


import exception.DoctorNotFoundException;
import lombok.NoArgsConstructor;
import model.Doctor;
import model.Patient;
import model.Profession;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
        if (type instanceof Patient patient) {
            patient.setRegisterDateTime(new Date());
            objects.add(type);
        }
        objects.add(type);
    }

    public User getUserByEmail(String email) {
        return (User) map.get(email);
    }


    public void searchDoctorByProfession(Profession profession) {
        for (T object : objects) {
            if (object instanceof Doctor doctor && profession.equals(doctor.getProfession())) {
                System.out.println(doctor);
                return;
            }
        }
        System.out.println("There is no doctor in this specialty.");
    }

    public void deleteDoctorById(int id) {
        if (!objects.isEmpty()) {
            boolean remove = objects.removeIf(o -> o instanceof Doctor doctor && id == doctor.getId());
            if (!remove) {
                System.out.printf("Doctor with %s id does not exist!!!",id);
            }
        }
        else {
            System.out.println("No doctors");
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
        if (objects.isEmpty()) {
            System.out.println("No doctors");
            return;
        }
        for (T object : objects) {
            if (object instanceof Doctor) {
                System.out.println(object);
            }
        }
    }

    public void printPatientsByDoctor(Doctor doctor) {
        if (objects.isEmpty()) {
            System.out.println("No patients");
            return;
        }

        boolean found = false;

        for (T object : objects) {
            if (object instanceof Patient && ((Patient) object).getDoctor().equals(doctor)) {
                System.out.println(object);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient with " + doctor.getName() + " id does not exist!!!");
        }
    }

    public void printAllPatients() {
        if (objects.isEmpty()) {
            System.out.println("No patients");
        }
        for (T object : objects) {
            if (object instanceof Patient patient) {
                System.out.println(patient);
            }
        }
    }

}
