package services;

class SMSSender implements MessageSender{
    public void sendMessage(String to, String message){
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
