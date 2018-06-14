package models.base;

import base.ValidationException;
import models.TicketPriority;

import java.util.Date;

public class Ticket extends Item {

    private Date dueDate;
    private String sender;
    private String owner;
    private TicketPriority priority;

    public Ticket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) throws ValidationException {
        super(title, description);
        setDueDate(dueDate);
        setSender(sender);
        setOwner(owner);
        setPriority(priority);
    }


    public void setDueDate(Date dueDate) throws ValidationException {
        if (dueDate.before(new Date())) {
            throw new ValidationException("Please dont enter past dates!");
        }
        this.dueDate = dueDate;
    }

    public void setSender(String sender) throws ValidationException {
        if (sender.length() < 2 || sender.length() > 10) {
            throw new ValidationException("Sender lenght should be between 2 and 10 symbols long");
        }
        this.sender = sender;
    }

    public void setOwner(String owner) throws ValidationException {
        if (owner.length() < 2 || owner.length() > 10) {
            throw new ValidationException("Owner lenght should be between 2 and 10 symbols long");
        }
        this.owner = owner;
    }

    public void setPriority(TicketPriority priority) throws ValidationException {
        if (priority == null) {
            throw new ValidationException("Please enter a valid priority");
        }
        this.priority = priority;
    }

    @Override
    public void view() {
        System.out.println("Type: Ticket");
        super.view();
        System.out.println("DueDate: " + dueDate);
        System.out.println("Sender: " + sender);
        System.out.println("Owner: "+ owner );
        System.out.println("Priority" +priority);
    }
}
