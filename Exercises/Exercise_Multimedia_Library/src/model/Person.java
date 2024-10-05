package model;

import java.util.ArrayList;

public final class Person {
    private String namePerson, idPerson;

    public Person() {
    }

    public Person(String namePerson, String idPerson) {
        this.namePerson = namePerson;
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }


    public void showData(){
        System.out.println("Name: " + namePerson);
        System.out.println("National Identification Number: " + idPerson);

    }
}
