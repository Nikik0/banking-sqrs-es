package com.nikik0.banking.domain.model.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;

@Converter
public class ObjectConverter implements AttributeConverter<Object, String> {

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    @Override
    public Object convertToEntityAttribute(String json) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(json, Object.class);
    }
}
