package org.ReceiptDigitialization.Models;

import java.util.Date;
import java.util.List;

public class Receipt {
    // Receipt properties
    private final Long receipt_id;
    private String receipt_title;
    private Date receipt_date;
    private List<Billable> billable_list;
    private double tax_rate;
    private String company_name;
    private String company_address;
    private String company_phone;
    private String company_email;
    private String person_name;
    private String person_address;
    private String person_phone;

    // Receipt Constructors
    public Receipt(Long receipt_id, String receipt_title, Date receipt_date, List<Billable> billable_list, double tax_rate, Company company, Person person) {
        this.receipt_id = receipt_id;
        this.receipt_title = receipt_title;
        this.receipt_date = receipt_date;
        this.billable_list = billable_list;
        this.tax_rate = tax_rate;
        this.company_name = company.getCompany_name();
        this.company_address = company.getCompany_address();
        this.company_phone = company.getCompany_phone();
        this.company_email = company.getCompany_email();
        this.person_name = person.getPerson_name();
        this.person_address = person.getPerson_address();
        this.person_phone = person.getPerson_phone();
    }

    // Receipt getter

    public Long getReceipt_id() {
        return receipt_id;
    }

    public String getReceipt_title() {
        return receipt_title;
    }

    public Date getReceipt_date() {
        return receipt_date;
    }

    public List<Billable> getBillable_list() {
        return billable_list;
    }

    public double getTax_rate() {
        return tax_rate;
    }

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
