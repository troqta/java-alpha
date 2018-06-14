package telerik;

import java.util.Date;

public class Notification {
    private DateProvider dateProvider;
    private Popup popup;
    private Date targetDate;
    private boolean isActive;

    public Notification(Date targetDate, Popup popup, DateProvider dateProvider) {
        this.dateProvider = dateProvider;
        this.popup = popup;
        this.targetDate = targetDate;
        this.isActive = true;
    }

    public void dismiss() {
        this.isActive = false;
    }
    public void sendNotification(){
        if(!isActive){
            return;
        }
        long now = dateProvider.getDate().getTime();

        long interval = targetDate.getTime() - now;
        int intervalInMinutes = (int)interval/60000;
        if(15 < intervalInMinutes && intervalInMinutes <30){
            showPopup();
        }
        else if(0<intervalInMinutes && intervalInMinutes< 5){
            sendEmail();
        }
        else {
            logOnFile();
        }
    }

    private void logOnFile() {
        System.out.println("I wrote something!");
    }

    private void sendEmail() {
        System.out.println("An email was sent");
    }

    private void showPopup() {
       popup.showPopup();
    }
}
