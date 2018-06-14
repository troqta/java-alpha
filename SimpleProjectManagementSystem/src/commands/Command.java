package commands;

public class Command {
    private String[] params;
    private CommandType commandType;

    public Command(CommandType type, String[] params) {
        setCommandType(type);
        setParams(params);
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
