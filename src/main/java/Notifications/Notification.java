package Notifications;

import App.GetProperties;
import Notifications.Providers.Mail.SendgridProvider;

import java.io.IOException;


public class Notification {

    private Object provider;
    private String from;
    private String to;
    private String subject;
    private String body;

    public Notification(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }


    public void sendMail () throws IOException {
        Object response = this.getAdapter();
    }


    /**
     * Here you can define the providers in the application
     * @return
     * @throws IOException
     */
    public Object getAdapter () throws IOException{
        GetProperties getProperties = new GetProperties();

        switch (getProperties.getProperty("email_provider")) {
            case "sendgrid":
                return new SendgridProvider(getProperties.getProperty("sendgrid_api_key")).SendEmail(from, to, subject, body);
            default:
                return new SendgridProvider(getProperties.getProperty("sendgrid_api_key")).SendEmail(from, to, subject, body);
        }
    }

}