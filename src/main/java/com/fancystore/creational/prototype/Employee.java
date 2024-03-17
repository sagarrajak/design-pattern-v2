package com.fancystore.creational.prototype;

import java.util.Arrays;

class Address {
    public String streetAddress, city, country;
    public Address() {}

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(Address address) {
        this(address.streetAddress, address.city, address.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


class Employee {
    public Address address;
    public String[] name;

    public Employee(Address address, String[] name) {
        this.address = address;
        this.name = name;
    }

    public Employee(Employee employee) {
        this(new Address(employee.address), Arrays.copyOf(employee.name, employee.name.length));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", name=" + Arrays.toString(name) +
                '}';
    }

    public static void main(String[] args) {
        Address address = new Address("Birsanagar, zone number 3, india", "jamshedpur", "India");
        Employee sagar = new Employee( address, new String[]{"sagar", "rajak"});
        System.out.println(sagar.toString());
        Employee employee = new Employee(sagar);
        employee.address.city = "asdsdfsd";
        employee.address.country = "USA";
        employee.name[1] = "Kumar";
        System.out.println(employee);
    }
}
