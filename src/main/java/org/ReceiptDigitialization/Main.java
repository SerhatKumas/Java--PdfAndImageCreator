package org.ReceiptDigitialization;

import org.ReceiptDigitialization.Models.*;
import org.ReceiptDigitialization.ReceiptDigitizers.ImageDigitizer;
import org.ReceiptDigitialization.ReceiptDigitizers.PdfDigitizer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PdfDigitizer pdf = new PdfDigitizer();
        ImageDigitizer img = new ImageDigitizer();
        List<Billable> billableList = new LinkedList<>();
        billableList.add(new Billable("Front-ent Development", 6, 15000));
        billableList.add(new Billable("Back-ent Development", 3, 20000));
        billableList.add(new Billable("Database Development", 3, 10000));
        billableList.add(new Billable("Ui-ux Development", 2, 5000));
        billableList.add(new Billable("Logic Development", 3, 15000));
        Company comp = new Company("Paradox Software Ltd. Sti", "Babacan sokak no : 37/10 Urla,Izmir", "05516217943", "paradoxsoftware@gmail.com");
        Person person_example = new Person("Sabri Tan","Osmangazi/Bursa","05536745698");
        pdf.digitizeReceipt(new Receipt(12345678910L,"Software Service Receipt", new Date(), billableList,0.18, comp, person_example));
        img.digitizeReceipt(new Receipt(12345678910L,"Software Service Receipt", new Date(), billableList,0.18, comp, person_example));

    }
}