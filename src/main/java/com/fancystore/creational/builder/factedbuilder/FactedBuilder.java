package com.fancystore.creational.builder.factedbuilder;

public class FactedBuilder {
    public static void main(String[] args) {
        var person = new PersonBuilder()
                .addressBuilder()
                    .setAddress("home no 36, block A, zone number 3")
                    .setCity("Jamshedpur")
                    .setPostalCode("831004")
                .employmentBuilder()
                    .setCompanyName("Un-Employed")
                    .setPosition("Self employed")
                    .setAnnualIncome(100000000)
                .build();
        System.out.println(person);
    }
}

class Person {
    public String streetAddress, postalCode, city;
    public String companyName, postion;

    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", postion='" + postion + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// builder facade


class PersonBuilder {
    protected Person person = new Person();

    public Person build() {
        return this.person;
    }

    public PersonAddressBuilder addressBuilder() {
        return new PersonAddressBuilder(person);
    }

    public PersonEmploymentBuilder employmentBuilder() {
        return new PersonEmploymentBuilder(person);
    }
}

class PersonAddressBuilder extends PersonBuilder {
    PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder setCity(String city) {
        this.person.city = city;
        return this;
    }

    public PersonAddressBuilder setPostalCode(String postalCode) {
        this.person.postalCode = postalCode;
        return this;
    }

    public PersonAddressBuilder setAddress(String address) {
        this.person.streetAddress = address;
        return this;
    }
}


class PersonEmploymentBuilder extends PersonBuilder {
    PersonEmploymentBuilder(Person person) {
        this.person = person;
    }
    public PersonEmploymentBuilder setPosition(String position) {
        this.person.postion = position;
        return this;
    }

    public PersonEmploymentBuilder setCompanyName(String companyName) {
        this.person.companyName = companyName;
        return this;
    }

    public PersonEmploymentBuilder setAnnualIncome(Integer income){
        this.person.annualIncome = income;
        return this;
    }
}