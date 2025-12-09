package services;
import CheckMethod;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private Notifier notifier = Notifier.EMAIL; //default Notifier
    private PaymentProcessor paymentProcessor = new PaymentProcessor();

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier){
        System.out.println("Processing reservation for " + res.customer.name);

        res.room.price *= new CityDiscount().CheckCityDiscount(res.customer); // must Fix this
                paymentProcessor.pay(res.totalPrice());

        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.name);
        System.out.println("hotel.Room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");
        CheckMethod checkMethod = new CheckMethod(this.notifier);
        MessageSender messageSender = checkMethod.type();
       messageSender.sendMessage();
    }
}