package com.nikik0.banking.service.transaction;

import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.service.CommandService;
import com.nikik0.banking.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
