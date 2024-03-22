package com.fancystore.behavioural.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ChatRoomExample {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Person person = new Person("sagar");
        Person person2 = new Person("sagar2");
        room.addNewPerson(person);
        room.addNewPerson(person2);

        person.say("hello room!");
        person2.say("Hey sagar, how you doing!");

        Person sunil = new Person("sunil");
        room.addNewPerson(sunil);
        sunil.say("hello everyone!");
        sunil.sendPrivate("sagar", "hey sagar how you doing bro!");
    }
}

class ChatRoom {
    HashMap<String, Person> people = new HashMap<>();

    public void addNewPerson(Person person) {
        people.put(person.getName(), person);
        String joinMessage = person.getName() + " Joins the rooms!";
        this.broadCast(person.getName(), joinMessage);
        person.setChatRoom(this);
    }

    public void broadCast(String name, String message) {
        for (Person person: people.values()) {
            if (!person.getName().equals(name))
                person.receive(name, message);
        }
    }

    public void message(String name, String to, String message) {
        Optional<Person> person = Optional.ofNullable(people.get(to));
        if (person.isPresent()) {
            Person newPerson = person.get();
            newPerson.receive(name, message);
        } else {
            System.out.println("Error: user not found!");
        }
    }
}

class Person {
    private  String name;
    private  List<String> chatLog = new ArrayList<>();

    private  ChatRoom chatRoom;

    public Person(String name) {
        this.name = name;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
        chatLog = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void receive(String sender, String message) {
        String s = sender+" : "+message;
        chatLog.add(s);
        System.out.println("[" + name + "'s chat session ] " + s);
    }

    public void say(String message) {
        chatRoom.broadCast(name, message);
    }

    public void sendPrivate(String to, String message) {
        chatRoom.message(name, to, message);
    }

}