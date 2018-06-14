import base.CommandParser;
import base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import models.base.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    private static final String EXIT_STATE = "EXIT";
    private final CommandParser commandParser;
    ProjectManagementSystem system;

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() throws ParseException {
        Scanner in = new Scanner(System.in);
        while (true) {
            String commandString = in.nextLine();
            Command command = this.commandParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            switch (command.getCommandType()) {
                case ADD_TODO:
                    String title = command.getParams()[0];
                    String description = command.getParams()[1];
                    TodoState state = TodoState.fromName(command.getParams()[2]);
                    system.addTodo(title, description, state);
                    break;
                case ADD_TASK:
                    title = command.getParams()[0];
                    description = command.getParams()[1];
                    String dueDateString = command.getParams()[2];
                    Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDateString);
                    TicketPriority priority = TicketPriority.fromName(command.getParams()[3]);
                    String plannedTimeString = command.getParams()[4];
                    Date plannedTime = new SimpleDateFormat("dd/MM/yyyy").parse(plannedTimeString);
                    String assignee = command.getParams()[5];
                    system.addTask(title, description, dueDate, priority, plannedTime, assignee);

                    break;
                case ADD_TICKET:
                    title = command.getParams()[0];
                    description = command.getParams()[1];
                    dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(command.getParams()[2]);
                    priority = TicketPriority.fromName(command.getParams()[3]);
                    String sender = command.getParams()[4];
                    String owner = command.getParams()[5];
                    system.addTicket(title, description, dueDate, priority, sender, owner);
                    break;
                case LIST_ALL:
                    system.listAll().forEach(Item::view);
                    break;
                case LIST_TASKS:
                    system.listTasks().forEach(Item::view);
                    break;
                case LIST_TODOS:
                    system.listTodos().forEach(Item::view);
                    break;
                case UPDATE_TODO:
                    String itemName = command.getParams()[0];
                    String todoState = command.getParams()[1];
                    system.changeTodoState(itemName, todoState);
                    break;
                case LIST_TICKETS:
                    system.listTickets().forEach(Item::view);
                    break;
                case LIST_TODOS_NOT_DONE:
                    system.listTodos(TodoState.NOT_DONE).forEach(Item::view);
                    break;
            }
        }
    }
}
