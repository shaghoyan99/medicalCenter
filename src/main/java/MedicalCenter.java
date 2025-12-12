import exception.DoctorNotFoundException;
import exception.ProfessionNotFoundException;
import exception.WrongEmailException;
import model.Doctor;
import model.Patient;
import model.Profession;
import storage.DoctorStorage;
import storage.PatientStorage;
import util.CheckEmailUtil;
import util.FillUtil;

import java.util.Scanner;

public class MedicalCenter implements Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorStorage ds = FillUtil.deserializeDoctorStorage();
    private static final PatientStorage ps = FillUtil.deserializePatientStorage();


    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Commands.printMainMenu();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT -> isRun = false;
                case ADD_DOCTOR -> {
                    addDoctor();
                    FillUtil.serializeDoctorData(ds);
                }
                case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
                case DELETE_DOCTOR_BY_ID -> {
                    deleteDoctorById();
                    FillUtil.serializeDoctorData(ds);
                }
                case CHANGE_DOCTOR_BY_ID -> {
                    changeDoctorById();
                    FillUtil.serializeDoctorData(ds);
                }
                case ADD_PATIENT -> {
                    addPatient();
                    FillUtil.serializePatientData(ps);
                }
                case PRINT_ALL_PATIENT_BY_DOCTOR -> printAllPatientsByDoctor();
                case PRINT_ALL_PATIENT -> ps.printAllPatients();
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Please input doctor name ");
        String name = scanner.nextLine();
        System.out.println("Please input doctor surname ");
        String surname = scanner.nextLine();
        System.out.println("Please input doctor phoneNumber ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input doctor email ");
        String emailStr = scanner.nextLine();
        try {
            String email = CheckEmailUtil.isValidEmail(emailStr);
            System.out.println("Please select doctor profession ");
            Commands.printProfessionLevelMenu();
            String professionCode = scanner.nextLine();
            Profession profession = Profession.fromCode(professionCode);
            Doctor doctor = new Doctor(ds.generateId(), name, surname, phoneNumber, email, profession);
            ds.addDoctor(doctor);
            System.out.println("Doctor was added !!!");
        } catch (ProfessionNotFoundException | WrongEmailException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchDoctorByProfession() {
        Commands.printProfessionLevelMenu();
        String professionCode = scanner.nextLine();
        try {
            Profession profession = Profession.fromCode(professionCode);
            ds.searchDoctorByProfession(profession);
        } catch (ProfessionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteDoctorById() {
        System.out.println("Please input doctor id");
        ds.printAllDoctors();
        int id = Integer.parseInt(scanner.nextLine());
        ds.deleteDoctorById(id);
    }

    private static void changeDoctorById() {
        System.out.println("Please input doctor id");
        ds.printAllDoctors();
        int id = Integer.parseInt(scanner.nextLine());
        try {
            Doctor doctorById = ds.getDoctorById(id);
            System.out.println("Please input doctor name ");
            String name = scanner.nextLine();
            System.out.println("Please input doctor surname ");
            String surname = scanner.nextLine();
            System.out.println("Please input doctor phoneNumber ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Please input doctor email ");
            String emailStr = scanner.nextLine();
            try {
                String email = CheckEmailUtil.isValidEmail(emailStr);
                System.out.println("Please select doctor profession ");
                Commands.printProfessionLevelMenu();
                String professionCode = scanner.nextLine();
                Profession profession = Profession.fromCode(professionCode);
                doctorById.setName(name);
                doctorById.setSurname(surname);
                doctorById.setPhoneNumber(phoneNumber);
                doctorById.setEmail(email);
                doctorById.setProfession(profession);
                System.out.println("Doctor was changed !!!");
            } catch (ProfessionNotFoundException | WrongEmailException e) {
                System.out.println(e.getMessage());
            }
        } catch (DoctorNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPatient() {
        System.out.println("Please input patient id for passport.(Only numbers) ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input patient name ");
        String name = scanner.nextLine();
        System.out.println("Please input patient surname ");
        String surname = scanner.nextLine();
        System.out.println("Please input patient phoneNumber ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please select doctor ");
        System.out.println("Please input doctor id");
        ds.printAllDoctors();
        int doctorId = Integer.parseInt(scanner.nextLine());
        try {
            Doctor doctorById = ds.getDoctorById(doctorId);
            Patient patient = new Patient(id, name, surname, phoneNumber, doctorById);
            ps.addPatient(patient);
            System.out.println("Patient was added !!!");
        } catch (DoctorNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printAllPatientsByDoctor() {
        System.out.println("Please input doctor id");
        ds.printAllDoctors();
        int doctorId = Integer.parseInt(scanner.nextLine());
        try {
            Doctor doctorById = ds.getDoctorById(doctorId);
            ps.printPatientsByDoctor(doctorById);
        } catch (DoctorNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
