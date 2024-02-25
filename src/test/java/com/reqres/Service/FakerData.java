package com.reqres.Service;

import com.github.javafaker.Faker;

public class FakerData {
    Faker faker = new Faker();

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getJob() {
        return faker.job().position();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }
}
