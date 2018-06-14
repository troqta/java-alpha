package telerik;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class NotificationTests {
    @Test
    public void sendNotificaion_should_doNothing_when_dismissed() {
        //Arrange
        Date now = new Date();
        Date targetDate = new Date(now.getTime());
        targetDate.setTime(now.getTime()+20*60000);
        MockDateProvider dateProvider = new MockDateProvider(now);
        MockPopup popup = new MockPopup();

        Notification notification = new Notification(targetDate, popup, dateProvider);

        //Act
        notification.dismiss();
        notification.sendNotification();

        //Assert
        Assert.assertFalse(popup.isPopupShown());
    }
    @Test
    public void sendNotification_should_showPopUp_when_24MinutesBefore(){
        //Arrange
        Date now = new Date();
        Date targetDate = new Date(now.getTime());
        targetDate.setTime(now.getTime()+20*60000);
        MockDateProvider dateProvider = new MockDateProvider(now);
        MockPopup popup = new MockPopup();

        Notification notification = new Notification(targetDate, popup, dateProvider);

        //Act

        notification.sendNotification();

        //Assert
        Assert.assertTrue(popup.isPopupShown());
    }
}

