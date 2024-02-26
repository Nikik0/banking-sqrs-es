package com.nikik0.banking.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(final String message){
        super(message);
    }
}
