package com.fancystore.structrual.decorator;

import com.fancystore.Main;

import java.io.*;
import java.util.Base64;

interface DataStore {
    void writeDate(String date);
    String readDate();
}

public class FileDateStore implements DataStore {
    private String name;

    public FileDateStore(String name) {
        this.name = name;
    }

    @Override
    public void writeDate(String data) {
        File file = new File(this.name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0 , data.length());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String readDate() {
        char[] buffer = null;
        File file = new File(this.name);
        try (FileReader fr = new FileReader(file)) {
            buffer = new char[(int)file.length()];
            fr.read(buffer);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return new String(buffer);
    }
}

class  Base64StoreDecorator implements  DataStore {
    private FileDateStore store;

    Base64StoreDecorator(FileDateStore store) {
        this.store = store;
    }

    @Override
    public void writeDate(String data) {
        byte[] bytes = Base64.getEncoder().encode(data.getBytes());
        this.store.writeDate(new String(bytes));
    }

    @Override
    public String readDate() {
        String data = this.store.readDate();
        byte[] out = Base64.getDecoder().decode(data.getBytes());
        return new String(out);
    }
}

class  Main2 {
    public static void main(String[] args) {
        FileDateStore fileDateStore = new FileDateStore("test.bin");
        fileDateStore.writeDate("without base64 encoding");
        System.out.println(fileDateStore.readDate());
        Base64StoreDecorator base64StoreDecorator = new Base64StoreDecorator(fileDateStore);
        base64StoreDecorator.writeDate("test sagar bla bla");
        System.out.println(base64StoreDecorator.readDate());
    }
}


