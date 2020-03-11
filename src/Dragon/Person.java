package Dragon;

import Dragon.Color;
import Dragon.Country;
import Dragon.Location;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    public Person(String name, LocalDateTime birthday, Color hairColor, Country nationality, Location location){
        this.name = name;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday.toString() + " " +
                ((hairColor == null) ? "" : hairColor) +
                ((nationality == null) ? " " : " " + nationality) + " " + location.toString();
    }
}
