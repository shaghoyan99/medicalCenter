package model;


import exception.ProfessionNotFoundException;
import lombok.Getter;

@Getter
public enum Profession {

    DENTIST("1"),
    SURGEON("2"),
    CARDIOLOGIST("3"),
    DERMATOLOGIST("4"),
    ANESTHESIOLOGIST("5"),
    ENDOCRINOLOGIST("6"),
    PLASTIC_SURGEON("7"),
    PEDIATRICIAN("8"),
    ;

    private final String code;

    Profession(String code) {
        this.code = code;
    }

    public static Profession fromCode(String code) throws ProfessionNotFoundException {
        for (Profession level : values()) {
            if (level.code.equals(code)) {
                return level;
            }
        }
        throw new ProfessionNotFoundException("Invalid profession level code: " + code);
    }
}
