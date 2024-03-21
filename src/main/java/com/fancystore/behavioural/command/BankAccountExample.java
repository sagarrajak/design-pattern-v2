package com.fancystore.behavioural.command;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BankAccountExample {
    public BankAccountExample(int balance) {
        this.balance = balance;
    }

    public int balance;
    private final int overDrafLimit = -500;

    public boolean withdraw(int amount) {
        if (this.balance - amount < overDrafLimit) {
            System.out.println("Overdraft limit react, transaction canceled!");
            return false;
        }
        this.balance -= amount;
        System.out.println("Withdraw amount " + amount);
        return true;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Added amount " + amount);
    }

    @Override
    public String toString() {
        return "BankAccountExample{" +
                "balance=" + balance +
                '}';
    }
}

abstract class Command {
    protected BankAccountExample ba;

    Command(BankAccountExample ba) {
        this.ba = ba;
    }

    abstract void call();

    abstract void undo();
}

class DebitAccountCommand extends Command {
    private int amount;
    private boolean isExecutedSuccessfully;

    DebitAccountCommand(BankAccountExample ba, int amount) {
        super(ba);
        this.amount = amount;
    }

    @Override
    public void call() {
        isExecutedSuccessfully = this.ba.withdraw(this.amount);
    }

    @Override
    void undo() {
        if(isExecutedSuccessfully)
            this.ba.deposit(this.amount);
    }
}

class CreditAccountCommand extends Command {
    private int amount;

    CreditAccountCommand(BankAccountExample ba, int amount) {
        super(ba);
        this.amount = amount;
    }

    @Override
    public void call() {
        this.ba.deposit(this.amount);
    }

    @Override
    void undo() {
        this.ba.withdraw(this.amount);
    }
}

class BankAccountHistory {
    public static void main(String[] args) {
        Stack<Command> bankComands = new Stack<>();
        BankAccountExample bankAccountExample = new BankAccountExample(100);
        List<Command> commands = List.of(
                new CreditAccountCommand(bankAccountExample, 100),
                new CreditAccountCommand(bankAccountExample, 399),
                new CreditAccountCommand(bankAccountExample, 500),
                new DebitAccountCommand(bankAccountExample, 300),
                new DebitAccountCommand(bankAccountExample, 200)
        );

        for (Command cmd: commands) {
            cmd.call();
            bankComands.push(cmd);
            System.out.println(bankAccountExample);
        }
        while (!bankComands.isEmpty()) {
            Command pop = bankComands.pop();
            pop.undo();
            System.out.println(bankAccountExample);
        }
    }
 }