package com.telerik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Channel> channels = new ArrayList<>();

        channels.add(new Channel("channel1"));
        channels.add(new Channel("channel2"));
        channels.add(new Channel("channel3"));


        Channel currentChannel;
        if (channels.size() > 0) {
            currentChannel = channels.get(0);
        } else {
            channels.add(new Channel("default channel"));
            currentChannel = channels.get(0);
        }
        currentChannel = getChannel("channel2", channels, currentChannel);
        currentChannel.addMessage(new Text("Az", "MESSAGE"));

    }

    public static Channel getChannel(String name, List<Channel> channels, Channel currentChannel) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                return channel;
            }
        }
        System.out.println("No channel with such name!");
        return currentChannel;
    }

    public static void listChannels(List<Channel> channels) {
        for (Channel channel : channels) {
            System.out.println(channel);
        }
    }
}
