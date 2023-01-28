package org.ReceiptDigitialization.ReceiptDigitizers;

import org.ReceiptDigitialization.Models.Receipt;

public interface IDigitizer {

    // Digitizing interface method
    void digitizeReceipt(Receipt receipt);
}