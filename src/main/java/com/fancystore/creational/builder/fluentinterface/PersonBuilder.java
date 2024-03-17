package com.fancystore.creational.builder.fluentinterface;

class Person {
    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", postion='" + position + '\'' +
                '}';
    }

    public String position;
}

public class PersonBuilder<T extends PersonBuilder<T>> {
    protected  Person person = new Person();

    PersonBuilder() {
        person = new Person();
    }
    public T withName(String name) {
        this.person.name = name;
        return self();
    }

    public Person build() {
        return this.person;
    }

    protected T self() {
        return (T)this;
    }
}


class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder withPosition(String position) {
        this.person.position = position;
        return this;
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class Demo {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person sagar = personBuilder.withName("Sagar").build();
        System.out.println(sagar);

        String string = new EmployeeBuilder().withName("name").withPosition("position").build().toString();
        System.out.println(string);
    }
}
