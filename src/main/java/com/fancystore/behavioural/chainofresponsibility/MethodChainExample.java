package com.fancystore.behavioural.chainofresponsibility;

import com.fancystore.Main;

public class MethodChainExample {
    public static void main(String[] args) {
        Creature sagar = new Creature("sagar", 1, 1);
        System.out.println(sagar);
        RootCreateModifier rootCreateModifier = new RootCreateModifier(sagar);
        AddingAttackPower addingAttackPower = new AddingAttackPower(sagar);
        CreatureDefencePower creatureDefencePower = new CreatureDefencePower(sagar);
        rootCreateModifier.setNext(addingAttackPower);
        rootCreateModifier.setNext(creatureDefencePower);
        rootCreateModifier.handleNext();
        System.out.println(sagar);
    }
}

class Creature {
    public String name;
    public int attack, defence;

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }

    public Creature(String name, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
    }
}

 class BaseCreatureModifier {
    protected Creature creature;
    protected  BaseCreatureModifier next;

    public BaseCreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void setNext(BaseCreatureModifier modifier) {
        if (next != null)
            next.setNext(modifier);
        else
            next = modifier;
    }


    public void handleNext() {
        if (this.next != null)
            this.next.handleNext();
    }
}

class RootCreateModifier extends BaseCreatureModifier {

    public RootCreateModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handleNext() {
        super.handleNext();
    }
}

class AddingAttackPower extends BaseCreatureModifier {

    public AddingAttackPower(Creature creature) {
        super(creature);
    }

    @Override
    public void handleNext() {
        this.creature.attack *= 2;
        super.handleNext();
    }
}


class CreatureDefencePower extends BaseCreatureModifier {
    public CreatureDefencePower(Creature creature) {
        super(creature);
    }

    @Override
    public void handleNext() {
        this.creature.defence *= 2;
        super.handleNext();
    }
}




