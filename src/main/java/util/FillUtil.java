package util;

import storage.DoctorStorage;
import storage.PatientStorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class FillUtil {

    private static final String DOCTOR_DATA_FILE = "D:\\Java Project\\medicalCenter\\src\\main\\resources\\data\\doctorData.data";
    private static final String PATIENT_DATA_FILE = "D:\\Java Project\\medicalCenter\\src\\main\\resources\\data\\patientData.data";

    public static void serializeDoctorData(DoctorStorage doctorStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DOCTOR_DATA_FILE))) {
            objectOutputStream.writeObject(doctorStorage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Doctor Data" + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Doctor Data" + e);
        }
    }

    public static void serializePatientData(PatientStorage patientStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATIENT_DATA_FILE))) {
            objectOutputStream.writeObject(patientStorage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Patient Data" + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Patient Data" + e);
        }
    }

    public static DoctorStorage deserializeDoctorStorage() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DOCTOR_DATA_FILE))) {
            Object object = objectInputStream.readObject();
            if (object instanceof DoctorStorage doctorStorage) {
                return doctorStorage;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Doctor Data " + e);
        } catch (IOException e) {
            System.out.println("Failed to Deserialize Doctor Data " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new DoctorStorage();
    }

    public static PatientStorage deserializePatientStorage() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATIENT_DATA_FILE))) {
            Object object = objectInputStream.readObject();
            if (object instanceof PatientStorage patientStorage) {
                return patientStorage;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Patient Data " + e);
        } catch (IOException e) {
            System.out.println("Failed to Deserialize Patient Data " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new PatientStorage();
    }

}

