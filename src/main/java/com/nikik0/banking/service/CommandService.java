package com.nikik0.banking.service;

public interface CommandService<T> {

    void create(T object);
}
