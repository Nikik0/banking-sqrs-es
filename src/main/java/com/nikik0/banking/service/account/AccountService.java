package com.nikik0.banking.service.account;


import com.nikik0.banking.domain.model.Account;
import com.nikik0.banking.service.CommandService;
import com.nikik0.banking.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {

}
