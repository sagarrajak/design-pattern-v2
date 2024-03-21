package com.fancystore.behavioural.chainofresponsibility;

import javax.management.relation.Role;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MiddlewareExample {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.register("sagarrajak858@gmail.com", "123");
        server.register("rajaksagar858@gmail.com", "123");
        server.register("admin@example.com", "123");
        Middleware middleware = Middleware.init(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleWare()
        );
        server.setMiddleware(middleware);

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}


abstract class Middleware {
    private Middleware next;
    public static Middleware init(Middleware start, Middleware ...rest) {
        Middleware head = start;
        for (Middleware middleware: rest) {
            head.next = middleware;
            head = middleware;
        }
        return start;
    }

    public abstract boolean check(String username, String password);

    public boolean checkNext(String userName, String password) {
        if (next == null)
            return true;
        else
            return next.check(userName, password);
    }
}


class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String username, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;

        if (request > this.requestPerMinute) {
            System.out.println("Request limit exceeds");
            return false;
        }

        return this.checkNext(username, password);
    }
}


class UserExistsMiddleware extends  Middleware {

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    private Server server;

    @Override
    public boolean check(String username, String password) {
        if (!server.hasEmail(username)) {
            System.out.println("user not found!");
            return false;
        }
        if (!server.isValidPassword(username, password)) {
            System.out.println("Invalid username or password");
            return false;
        }
        return checkNext(username, password);
    }
}

class RoleCheckMiddleWare extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}


class Server {
    private Middleware middleware;
    private HashMap<String, String> users = new HashMap<>();

    Server() {}

    public void  setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}