package com.nikik0.banking.web.dto.mapper;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto>{
}
