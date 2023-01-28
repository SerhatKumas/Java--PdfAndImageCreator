package org.ReceiptDigitialization.ReceiptDigitizers;

import org.ReceiptDigitialization.Models.Billable;
import org.ReceiptDigitialization.Models.Receipt;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageDigitizer implements IDigitizer{
    @Override
    public void digitizeReceipt(Receipt receipt) {
        //https://examples.javacodegeeks.com/desktop-java/imageio/create-image-file-from-graphics-object/

        // Image size
        int width = 500;
        int height = 800;
        // Tax price calculation
        double total_without_tax = 0;
        // Writing new line solution
        int line_counter = 400;

        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // Fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        // Create a string with yellow
        g2d.setColor(Color.black);
        g2d.drawString("Receipt id : "+receipt.getReceipt_id(),50, 120);
        g2d.drawString("Receipt title : "+receipt.getReceipt_title(),50, 140);
        g2d.drawString("Receipt date : " + receipt.getReceipt_date(),50, 160);
        g2d.drawString("-----------------------------------------------------",50, 180);
        g2d.drawString("Company Name : " + receipt.getCompany_name(),50, 200);
        g2d.drawString("Company Address : " + receipt.getCompany_address(),50, 220);
        g2d.drawString("Company Phone : " + receipt.getCompany_phone(),50, 240);
        g2d.drawString("Company Email : "+receipt.getCompany_email(),50, 260);
        g2d.drawString("-----------------------------------------------------",50, 280);
        g2d.drawString("Billed to Name : " + receipt.getPerson_name(),50, 300);
        g2d.drawString("Billed to Address : " + receipt.getPerson_address(),50, 320);
        g2d.drawString("Billed to Phone : " + receipt.getPerson_phone(),50, 340);
        g2d.drawString("-----------------------------------------------------",50, 360);
        g2d.drawString("Billable Content | Billable Quantity | Billable Per Price | Billable Total Price ",50, 380);
        // Billable list writing to image
        for(int i = 0; i < receipt.getBillable_list().size(); i++) {
            Billable bill = receipt.getBillable_list().get(i);
            g2d.drawString(bill.getBillable_substance()+" | "+bill.getBillable_quantity()+" | "+bill.getPrice_per_billable()+" | "+bill.getTotal_billable_price(),50, line_counter);
            line_counter += 20;
            total_without_tax += bill.getTotal_billable_price();
        }
        g2d.drawString("-----------------------------------------------------",50, line_counter);
        line_counter += 20;
        g2d.drawString("Total Price (No Tax) : " + total_without_tax,50, line_counter);
        line_counter += 20;
        g2d.drawString("Tax Rate : " + receipt.getTax_rate(),50, line_counter);
        line_counter += 20;
        g2d.drawString("Total Price : " + (total_without_tax + (total_without_tax * receipt.getTax_rate())),50, line_counter);

        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();

        // Save as PNG
        File file = new File("receipt.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Save as JPEG
       // file = new File("myimage.jpg");
       // ImageIO.write(bufferedImage, "jpg", file);

    }

}
