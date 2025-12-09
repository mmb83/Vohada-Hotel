package services;
import services.CheckMethod;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private Notifier notifier = Notifier.EMAIL; //default Notifier
    private PaymentProcessor paymentProcessor = new PaymentProcessor(PaymentMethods.CARD); // default Payment

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier){
        System.out.println("Processing reservation for " + res.customer.getName());

        res.room.price *= new CityDiscount().CheckCityDiscount(res.customer); 
        paymentProcessor.pay(res.totalPrice());

       printInvoice(res);
       CheckMethod checkMethod = new CheckMethod(this.notifier);
       MessageSender messageSender = checkMethod.type();
       messageSender.sendMessage(res.customer.getEmail(), "Reservation for " + res.customer.getName());
    }


    public void printInvoice(Reservation res){
        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.getName());
        System.out.println("hotel.Room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");
    }
}



