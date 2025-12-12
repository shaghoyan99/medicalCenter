package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Person implements Serializable {

    private String email;
    private Profession profession;

    public Doctor(int id, String name, String surname, String phoneNumber, String email, Profession profession) {
    }


    @Override
    public String toString() {
        return "Doctor{" +
                super.toString() +
                ", email='" + email + '\'' +
                ", profession=" + profession +
                '}';
    }
}
