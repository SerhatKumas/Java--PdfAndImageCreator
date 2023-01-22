package org.ReceiptDigitialization.Models;

public class Billable {
    private String billable_substance;
    private int billable_quantity;
    private double price_per_billable;
    private double total_billable_price;

    public Billable(String billable_substance, int billable_quantity, double price_per_billable) {
        this.billable_substance = billable_substance;
        this.billable_quantity = billable_quantity;
        this.price_per_billable = price_per_billable;
        this.total_billable_price = price_per_billable*billable_quantity;
    }
}
