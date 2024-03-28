package com.fancystore.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class Workout {
}



class Participant
{
    public int value = 0;
    private Mediator mediator;
    public String name;
    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
    }

    public void say(int n)
    {
        this.mediator.broadcast(name, n);
    }

    public void increase(int value) {
        this.value += value;
    }

    public int getValue() {
        return this.value;
    }
}


class Mediator
{
    List<Participant> lst = new ArrayList<>();
    Participant first = new Participant(this);
    Participant second = new Participant(this);



    public void broadcast(String name, int value) {
        for (Participant pt: lst) {
//            if (pt.getName() != name) {
//                pt.increase(value);
//            }
        }
    }
}





