package org.ReceiptDigitialization.ReceiptDigitizers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.ReceiptDigitialization.Models.Billable;
import org.ReceiptDigitialization.Models.Receipt;

import java.io.FileOutputStream;


public class PdfDigitizer implements IDigitizer {

    @Override
    public void digitizeReceipt(Receipt receipt) {
        // Total price before adding tax calculation
        double total_without_tax = 0;

        // Document creation
        Document document = new Document();
        try {
            // Pdf creation
            PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        document.open();

        try {
            // Writing necessary information to pdf
            document.add(new Paragraph("Receipt id : "+receipt.getReceipt_id()));
            document.add(new Paragraph("Receipt title : "+receipt.getReceipt_title()));
            document.add(new Paragraph("Receipt date : " + receipt.getReceipt_date()));
            document.add(new Paragraph("--------------------------------------------------------------------------------"));
            document.add(new Paragraph("Company Name : " + receipt.getCompany_name()));
            document.add(new Paragraph("Company Address : " + receipt.getCompany_address()));
            document.add(new Paragraph("Company Phone : " + receipt.getCompany_phone()));
            document.add(new Paragraph("Company Email : "+receipt.getCompany_email()));
            document.add(new Paragraph("--------------------------------------------------------------------------------"));
            document.add(new Paragraph("Billed to Name : " + receipt.getPerson_name()));
            document.add(new Paragraph("Billed to Address : " + receipt.getPerson_address()));
            document.add(new Paragraph("Billed to Phone : " + receipt.getPerson_phone()));
            document.add(new Paragraph("--------------------------------------------------------------------------------"));
            document.add(new Paragraph("Billable Content | Billable Quantity | Billable Per Price | Billable Total Price "));
            // Billable list writing to pdf
            for(int i = 0; i < receipt.getBillable_list().size(); i++) {
                Billable bill = receipt.getBillable_list().get(i);
                document.add(new Paragraph(bill.getBillable_substance()+" | "+bill.getBillable_quantity()+" | "+bill.getPrice_per_billable()+" | "+bill.getTotal_billable_price()));
                // Total price calculation without tax
                total_without_tax += bill.getTotal_billable_price();
            }
            document.add(new Paragraph("--------------------------------------------------------------------------------"));
            document.add(new Paragraph("Total Price (No Tax) : " + total_without_tax));
            document.add(new Paragraph("Tax Rate : " + receipt.getTax_rate()));
            document.add(new Paragraph("Total Price : " + (total_without_tax + (total_without_tax * receipt.getTax_rate()))));


        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        // Closing document
        document.close();
    }

}
