package com.github.jsjchai;

import com.github.jsjchai.impl.UserServiceImpl;
import com.google.inject.AbstractModule;

public class UserModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
    }
}
