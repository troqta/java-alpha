package com.telerik;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private List<Message> messages;

    public Channel(String name) {
        this.name = name;
        messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        System.out.println("Message added");
        messages.add(message);
    }

    public void clearMessages() {
        System.out.println("History has been cleared");
        messages.clear();
    }

    public void listHistory() {
        System.out.println("----------------");
        for (Message message : messages) {
            message.showMessage();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
