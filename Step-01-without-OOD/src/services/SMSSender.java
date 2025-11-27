package services;

class SMSSender implements MessageSender{
    public void sendSMS(String to, String message){
        System.out.println("Sending SMS to " + to + ": " + message);
    }
    public void sendEmail(String to, String message){

    }
}
