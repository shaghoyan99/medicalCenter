package util;

import storage.Storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class FillUtil {

    public static final String DOCTOR_DATA_FILE = "D:\\Java Project\\medicalCenter\\src\\main\\resources\\data\\doctorData.data";
    public static final String PATIENT_DATA_FILE = "D:\\Java Project\\medicalCenter\\src\\main\\resources\\data\\patientData.data";
    public static final String USER_DATA_FILE = "D:\\Java Project\\medicalCenter\\src\\main\\resources\\data\\userData.data";

    public static <T> void writeDataDoctor(Storage<T> storage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DOCTOR_DATA_FILE))) {
            objectOutputStream.writeObject(storage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Doctor Data" + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Doctor Data" + e);
        }
    }
    public static <T> void writeDataPatient(Storage<T> storage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATIENT_DATA_FILE))) {
            objectOutputStream.writeObject(storage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Patient Data" + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize Patient Data" + e);
        }
    }
    public static <T> void writeDataUser(Storage<T> storage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            objectOutputStream.writeObject(storage);
        } catch (FileNotFoundException e) {
            System.out.println("File not found for User Data" + e);
        } catch (IOException e) {
            System.out.println("Failed to Serialize User Data" + e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Storage<T> readData(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = objectInputStream.readObject();
            if (object instanceof Storage<?> storage) {
                return (Storage<T>) storage;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found for Doctor Data " + e);
        } catch (IOException e) {
            System.out.println("Failed to Deserialize Doctor Data " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Storage<>();
    }

}

