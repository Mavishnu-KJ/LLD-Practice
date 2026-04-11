package lld.parkinglot;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private Ticket ticket;
    private Double amount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;

    //Constructor
    public Payment(Ticket ticket, double amount) {
        this.paymentId = "P" + System.currentTimeMillis();
        this.ticket = ticket;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentTime = LocalDateTime.now();
    }

    //Getter methods
    public String getPaymentId() {
        return paymentId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    //LLD purpose method to mark payment as success - In real world application, we use payment gateway here
    public void markAsSuccess() {
        this.paymentStatus = PaymentStatus.SUCCESS;
        System.out.println("✅ Payment successful: ₹" + amount + " for Ticket " + ticket.getTicketId()+" Vehicle "+ getTicket().getVehicle().getLicensePlate());
    }




}
