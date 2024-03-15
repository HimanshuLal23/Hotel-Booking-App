package Model;

import java.util.UUID;
import Model.PaymentType;

public class Payment {

    private UUID paymentId;
    private PaymentType paymentType;
    private double totalAmount;
    private boolean success;
    private double taxRate;
    private double netTotalAmount;

    public Payment(PaymentType paymentType, double totalAmount,boolean success) {
        this.paymentId = UUID.randomUUID();
        this.paymentType = paymentType;
        this.totalAmount = totalAmount;
        this.success = success;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getNetTotalAmount() {
        return netTotalAmount-getTaxAmount();
    }

    public double getTaxAmount() {
        return (netTotalAmount*taxRate);
    }

    public void setNetTotalAmount(double netTotalAmount) {
        this.netTotalAmount = netTotalAmount;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isSuccess() {
        return success;
    }
}
