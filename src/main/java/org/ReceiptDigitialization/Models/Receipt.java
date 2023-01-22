package org.ReceiptDigitialization.Models;

import java.util.Date;
import java.util.List;

public class Receipt {
    private Long receipt_id;
    private String receipt_title;
    private Date receipt_date;
    private List<Billable> billable_list;
    private double tax_rate;
    private double total_without_tax;
    private double total_with_tax;
    private String company_name;
    private String company_address;
    private String company_phone;
    private String company_email;
    private String person_name;
    private String person_address;
    private String person_phone;

    public Receipt(Long receipt_id, String receipt_title, Date receipt_date, List<Billable> billable_list, double tax_rate, double total_without_tax, double total_with_tax, Company company, Person person) {
        this.receipt_id = receipt_id;
        this.receipt_title = receipt_title;
        this.receipt_date = receipt_date;
        this.billable_list = billable_list;
        this.tax_rate = tax_rate;
        this.total_without_tax = total_without_tax;
        this.total_with_tax = total_with_tax;
        this.company_name = company.getCompany_name();
        this.company_address = company.getCompany_address();
        this.company_phone = company.getCompany_phone();
        this.company_email = company.getCompany_email();
        this.person_name = person.getPerson_name();
        this.person_address = person.getPerson_address();
        this.person_phone = person.getPerson_phone();
    }
}
