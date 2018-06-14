package models.base;

import base.ValidationException;
import models.TodoState;

public class TODO extends Item {
    private TodoState state;

    public TODO(String title, String description, TodoState state) throws ValidationException {
        super(title, description);
        setState(state);
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) throws ValidationException {
        if (state == null) {
            throw new ValidationException("Please enter a valid state");
        }
        this.state = state;
    }

    @Override
    public void view() {
        System.out.println("Type: TODO");
        super.view();
        System.out.println("State: " + state);
    }
}
