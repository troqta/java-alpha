import base.CommandParser;
import base.ValidationException;
import commands.Command;
import commands.CommandType;

import java.util.Arrays;

public class CommandParserImpl implements CommandParser {
    private static final String ADD_TODO_COMMAND_NAME = "ADD-TODO";

    @Override
    public Command parseCommand(String commandString) {
        String[] commandParts = commandString.split(" ");

        CommandType commandType = null;
        try {
            commandType = getCommandTypeByName(commandParts[0]);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        String[] args = Arrays.copyOfRange(commandParts, 1, commandParts.length);
        return new Command(commandType, args);
    }

    private CommandType getCommandTypeByName(String commandName) throws ValidationException {
        switch (commandName) {
            case "ADD-TODO":
                return CommandType.ADD_TODO;
            case "ADD-TICKET":
                return CommandType.ADD_TICKET;
            case "ADD-TASK":
                return CommandType.ADD_TASK;
            case "UPDATE-TODO":
                return CommandType.UPDATE_TODO;
            case "LIST-ALL":
                return CommandType.LIST_ALL;
            case "LIST-TODOS":
                return CommandType.LIST_TODOS;
            case "LIST-TODOS-NOT-DONE":
                return CommandType.LIST_TODOS_NOT_DONE;
            case "LIST-TICKETS":
                return CommandType.LIST_TICKETS;
            case "LIST-TASKS":
                return CommandType.LIST_TASKS;
            case "EXIT":
                return CommandType.EXIT;
            case "":
                return CommandType.EXIT;

            default:
                throw new ValidationException("Incorrect command name!");
        }


    }
}
