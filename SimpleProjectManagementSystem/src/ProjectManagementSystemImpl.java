import base.Data;
import base.ProjectManagementSystem;
import base.ValidationException;
import models.ItemsList;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import models.base.TODO;
import models.base.Task;
import models.base.Ticket;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {
    private Data data;

    public ProjectManagementSystemImpl() {
        data = new ItemsList();
    }

    @Override
    public void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) {

        try {
            data.addItem(new Ticket(title, description, dueDate, priority, sender, owner));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addTodo(String title, String description, TodoState state) {
        try {
            data.addItem(new TODO(title, description, state));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee) {
        try {
            data.addItem(new Task(title, description, dueDate, priority, plannedTime, assignee));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Item> listAll() {
        return data.getItems().stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTickets() {
        return data.getItems().stream()
                .filter(x -> x instanceof Ticket)
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTodos() {
        return data.getItems().stream()
                .filter(x -> x instanceof TODO)
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTodos(TodoState state) {
        return data.getItems().stream()
                .filter(x -> x instanceof TODO)
                .filter(x -> ((TODO) x).getState().equals(state))
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTasks() {
        return data.getItems().stream()
                .filter(x -> x instanceof Task)
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> searchByTitleOrDescription(String pattern) {
        return data.getItems().stream()
                .filter(x -> x.getTitle().equals(pattern) || x.getDescription().equals(pattern))
                .collect(Collectors.toList());
    }

    @Override
    public void changeTodoState(String itemName, String state) {
        for (Item item : data.getItems()) {
            if (item instanceof TODO) {
                if (item.getTitle().equals(itemName)) {
                    try {
                        ((TODO) item).setState(TodoState.fromName(state));
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

            }
        }

    }
}
