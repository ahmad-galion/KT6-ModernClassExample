import java.util.function.Consumer;


//old way
class Mailer {
    public void from(String from) {}
    public void to(String to) {}
    public void subject(String Subject) {}
    public void body(String body) {}
    public void send() {}
}


//modern class
class MailerModern {
    private MailerModern() {}
    public MailerModern from(String from) {System.out.println("from");return this;}
    public MailerModern to(String to) {System.out.println("to");return this;}
    public MailerModern subject(String Subject) {System.out.println("Subject");return this;}
    public MailerModern body(String body) {System.out.println("body");return this;}
    public static void send(Consumer<MailerModern> mailerModernConsumer) {
        MailerModern mailerModern= new MailerModern();
        mailerModernConsumer.accept(mailerModern);
        System.out.println("send");
    }
}

public class MainClass {


    public static void main(String[] args) {

            MailerModern.send(MainClass::prepareFun);

    }

    private static void prepareFun(MailerModern mailerModern) {
        mailerModern.body("galiun@gmail.com")
                .from("from@gmail.com")
                .subject("subject");

    }
}
