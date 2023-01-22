package org.ReceiptDigitialization.Models;

public class Company {

    private String company_name;
    private String company_address;
    private String company_phone;
    private String company_email;

    public Company(String company_name, String company_address, String company_phone, String company_email) {
        this.company_name = company_name;
        this.company_address = company_address;
        this.company_phone = company_phone;
        this.company_email = company_email;
    }
}
