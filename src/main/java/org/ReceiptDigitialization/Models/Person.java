package org.ReceiptDigitialization.Models;

public class Person {
    private String person_name;
    private String person_address;
    private String person_phone;


    public Person(String person_name, String person_address, String person_phone) {
        this.person_name = person_name;
        this.person_address = person_address;
        this.person_phone = person_phone;
    }

    public String getPerson_name() {
        return person_name;
    }

    public String getPerson_address() {
        return person_address;
    }

    public String getPerson_phone() {
        return person_phone;
    }
}

