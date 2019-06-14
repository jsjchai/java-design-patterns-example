package com.github.jsjchai;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new UserModule());

        injector.getInstance(UserService.class);

    }
}
