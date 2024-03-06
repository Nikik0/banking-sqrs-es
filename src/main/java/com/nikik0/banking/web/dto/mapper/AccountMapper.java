package com.nikik0.banking.web.dto.mapper;


import com.nikik0.banking.domain.model.Account;
import com.nikik0.banking.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto>{
}
