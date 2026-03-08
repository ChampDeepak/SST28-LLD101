package com.example.payments;

class FastPayAdapter implements PaymentGateway
{
    FastPayClient fastPayClient; 

    FastPayAdapter(FastPayClient fastPayClient)
    {
        this.fastPayClient = fastPayClient; 
    }

    @Override
    public String charge(String customerId, int amountCents) 
    {
        String id = fastPayClient.payNow(customerId, amountCents); 
        return id; 
    }

}