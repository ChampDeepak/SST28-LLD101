package com.example.payments;

public class SafeCashAdapter implements PaymentGateway
{
    SafeCashClient safeCashClient; 
    SafeCashAdapter(SafeCashClient safeCashClient)
    {
        this.safeCashClient = safeCashClient; 
    }
    
    @Override
    public String charge(String customerId, int amountCents) 
    {
        SafeCashPayment safeCashPayment = this.safeCashClient.createPayment(amountCents, customerId); 
        String id = safeCashPayment.confirm(); 
        return id; 
    }
    
}
