package org.ReceiptDigitialization.Models;

public class Company {

    // Company properties
    private String company_name;
    private String company_address;
    private String company_phone;
    private String company_email;

    // Company constructors
    public Company(String company_name, String company_address, String company_phone, String company_email) {
        this.company_name = company_name;
        this.company_address = company_address;
        this.company_phone = company_phone;
        this.company_email = company_email;
    }

    // Company getters
    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public String getCompany_email() {
        return company_email;
    }
}
