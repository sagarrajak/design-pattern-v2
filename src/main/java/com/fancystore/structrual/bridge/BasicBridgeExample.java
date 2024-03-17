package com.fancystore.structrual.bridge;



interface Device {
    boolean isEnabled();
    void disable();
    void enable();

    void setVolume(float percentage);

    float getVolume();

    int getChannel();

    void setChannel(int channel);

    void printDetails();
}

interface  Remote {
    void power();
    void volumeUp();
    void volumeDown();
    void channelUp();
    void channelDown();
}

class Radio implements   Device {
    private float volume = 0;
    private boolean power = false;

    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return power;
    }

    @Override
    public void disable() {
        power = false;
    }

    @Override
    public void enable() {
        power = true;
    }

    @Override
    public void setVolume(float percentage) {
    if (percentage <= 100 && percentage >= 0)
        volume = percentage;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        int MAX_CHANEL = 10;
        if (channel  <= MAX_CHANEL && channel >= 1)
            this.channel = channel;
    }

    @Override
    public void printDetails() {
        System.out.println("------------------------------------");
        System.out.println("| I'm radio.");
        System.out.println("| I'm " + (power ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}

class Tv implements Device {

    private float volume = 0;
    private boolean power = false;

    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return power;
    }

    @Override
    public void disable() {
        power = false;
    }

    @Override
    public void enable() {
        power = true;
    }

    @Override
    public void setVolume(float percentage) {
        if (percentage <= 100 && percentage >= 0)
            volume = percentage;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        int MAX_CHANEL = 10;
        if (channel  <= MAX_CHANEL && channel >= 1)
            this.channel = channel;
    }

    @Override
    public void printDetails() {
        System.out.println("------------------------------------");
        System.out.println("| I'm TV set.");
        System.out.println("| I'm " + (power ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}

class RemoteControl implements Remote {
    Device device;
    public RemoteControl(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if (device.isEnabled()) {
            device.disable();
        } else  {
            device.enable();
        }
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() +1);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 1);
    }

    @Override
    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }
}

public class BasicBridgeExample {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    private static void testDevice(Device device) {
        RemoteControl remoteControl = new RemoteControl(device);
        remoteControl.power();
        remoteControl.channelUp();
        device.printDetails();
    }
}


