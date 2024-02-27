package com.nikik0.banking.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID T);
}
