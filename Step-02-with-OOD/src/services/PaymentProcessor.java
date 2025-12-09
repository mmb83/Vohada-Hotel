package services;

class PaymentProcessor {
    private PaymentMethods method;
    public PaymentProcessor(PaymentMethods method)
    {
        this.method=method;
    }
    public void payByCard(double amount){ System.out.println("Paid by "+this.method.name()+": "+amount); }
}