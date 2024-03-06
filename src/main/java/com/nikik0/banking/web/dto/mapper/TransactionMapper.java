package com.nikik0.banking.web.dto.mapper;

import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto>{
}
