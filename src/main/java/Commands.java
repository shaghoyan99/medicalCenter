
import static model.Profession.ANESTHESIOLOGIST;
import static model.Profession.CARDIOLOGIST;
import static model.Profession.DENTIST;
import static model.Profession.DERMATOLOGIST;
import static model.Profession.ENDOCRINOLOGIST;
import static model.Profession.PEDIATRICIAN;
import static model.Profession.PLASTIC_SURGEON;
import static model.Profession.SURGEON;

public interface Commands {

    String EXIT = "0";
    String LOGIN = "1";
    String REGISTER = "2";

    String LOGOUT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BY_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_ALL_PATIENT_BY_DOCTOR = "6";
    String PRINT_ALL_PATIENT = "7";

    static void printMainManu() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + LOGIN + " for login");
        System.out.println("Please input " + REGISTER + " for register");
    }

    static void printUserMenu() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_DOCTOR + " for added doctor");
        System.out.println("Please input " + SEARCH_DOCTOR_BY_PROFESSION + " for search doctor by profession");
        System.out.println("Please input " + DELETE_DOCTOR_BY_ID + " for delete doctor by id");
        System.out.println("Please input " + CHANGE_DOCTOR_BY_ID + " for change doctor by id");
        System.out.println("Please input " + ADD_PATIENT + " for added patient");
        System.out.println("Please input " + PRINT_ALL_PATIENT_BY_DOCTOR + " for print all patient by doctor");
        System.out.println("Please input " + PRINT_ALL_PATIENT + " for print all patient");
    }

    static void printProfessionLevelMenu() {
        System.out.println("Please select profession ");
        System.out.println("Please input " + DENTIST.getCode() + " for " + DENTIST);
        System.out.println("Please input " + SURGEON.getCode() + " for " + SURGEON);
        System.out.println("Please input " + CARDIOLOGIST.getCode() + " for " + CARDIOLOGIST);
        System.out.println("Please input " + DERMATOLOGIST.getCode() + " for " + DERMATOLOGIST);
        System.out.println("Please input " + ANESTHESIOLOGIST.getCode() + " for " + ANESTHESIOLOGIST);
        System.out.println("Please input " + ENDOCRINOLOGIST.getCode() + " for " + ENDOCRINOLOGIST);
        System.out.println("Please input " + PLASTIC_SURGEON.getCode() + " for " + PLASTIC_SURGEON);
        System.out.println("Please input " + PEDIATRICIAN.getCode() + " for " + PEDIATRICIAN);
    }

}
