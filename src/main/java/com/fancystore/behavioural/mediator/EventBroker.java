package com.fancystore.behavioural.mediator;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventBroker extends Observable<FootballPlayer> {
    private final List<Observer<? super FootballPlayer>> observerList = new ArrayList<>();
    @Override
    protected void subscribeActual(@NonNull Observer<? super FootballPlayer> observer) {
        observerList.add(observer);
    }

    public void publich(FootballPlayer playerWithGoal) {
        for (Observer<? super FootballPlayer> observer: observerList) {
            observer.onNext(playerWithGoal);
        }
    }
}

class FootballPlayer {
    private String name;
    private final EventBroker broker;

    private Integer goalScored = 0;

    public FootballPlayer(EventBroker broker, String name) {
        this.broker = broker;
        this.name = name;
    }

    public void goalScored() {
        this.goalScored++;
        this.broker.publich(this);
    }

    public String getName() {
        return name;
    }

    public Integer getGoalScored() {
        return goalScored;
    }
}

class FootballCoach {
    public FootballCoach(EventBroker broker) {
        broker.subscribe(f -> {
            System.out.println(f.getName()+": Goaled new goal , total goals now is "+f.getGoalScored());
        });
    }
}

class EventBrokerDemo {
    public static void main(String[] args) {
        EventBroker eventBroker = new EventBroker();
        FootballPlayer player = new FootballPlayer(eventBroker, "player");
        FootballPlayer player2 = new FootballPlayer(eventBroker, "player2");
        FootballPlayer player3 = new FootballPlayer(eventBroker, "player3");
        new FootballCoach(eventBroker);
        player2.goalScored();
        player3.goalScored();
        player.goalScored();
        player.goalScored();
    }
}




