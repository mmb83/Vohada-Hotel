package services;
import MessageSender;
public class CheckMethod{
    private Notifier notifier;
    public CheckMethod(Notifier notifier){
        this.notifier=notifier;
    }
    public MessageSender type()
    {
        if (this.notifier==Notifier.EMAIL) {
            return new EmailSender();
        }
        return new SMSSender();
    }
}