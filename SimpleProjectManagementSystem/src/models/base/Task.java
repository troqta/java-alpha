package models.base;

import base.ValidationException;
import models.TicketPriority;

import java.util.Date;

public class Task extends Item{
    private String assignee;
    private Date plannedTime;
    private Date dueDate;
    private TicketPriority priority;

    public Task(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee) throws ValidationException {
        super(title, description);
        setAssignee(assignee);
        setPlannedTime(plannedTime);
        setDueDate(dueDate);
        setPriority(priority);
    }

    public void setAssignee(String assignee) throws ValidationException {
        if(assignee.length()<2 || assignee.length()>10) {
            throw new ValidationException("assignee should be between 2 and 10 symbols long");

        }
        this.assignee = assignee;
    }

    public void setPlannedTime(Date plannedTime) throws ValidationException {
        if(plannedTime.before(new Date())){
            throw new ValidationException("Please dont enter past dates!");
        }
        this.plannedTime = plannedTime;
    }

    public void setDueDate(Date dueDate) throws ValidationException {
        if(dueDate.before(new Date())){
            throw new ValidationException("Please dont enter past dates!");
        }
        this.dueDate = dueDate;
    }

    public void setPriority(TicketPriority priority) throws ValidationException {
        if(priority == null){
            throw new ValidationException("Please enter a valid priority");
        }
        this.priority = priority;
    }

    @Override
    public void view() {
        System.out.println("Type: Task");
        super.view();
        System.out.println("dueDate"+dueDate);
        System.out.println("Priority" + priority);
        System.out.println("Planned time" + plannedTime);
        System.out.println("Assignee" + assignee);
    }
}
