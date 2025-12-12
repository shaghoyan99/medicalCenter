package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person implements Serializable {

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }
}
