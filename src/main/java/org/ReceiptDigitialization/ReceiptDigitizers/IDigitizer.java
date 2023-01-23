package org.ReceiptDigitialization.ReceiptDigitizers;

import org.ReceiptDigitialization.Models.Receipt;

public interface IDigitizer {

    void digitizeReceipt(Receipt receipt);
}