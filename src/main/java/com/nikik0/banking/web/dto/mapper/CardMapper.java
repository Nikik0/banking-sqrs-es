package com.nikik0.banking.web.dto.mapper;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto>{
}
