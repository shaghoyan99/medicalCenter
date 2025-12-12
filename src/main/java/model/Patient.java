package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.DateUtil;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Person implements Serializable {

    private Doctor doctor;
    private Date registerDateTime;

    public Patient(int id, String name, String surname, String phoneNumber, Doctor doctor) {
        super(id, name, surname, phoneNumber);
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient {" +
                super.toString() +
                " doctor= " + doctor +
                ", registerDateTime=" + DateUtil.fromDateToStr(registerDateTime) +
                '}';
    }
}
