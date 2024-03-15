package com.nikik0.banking.web.security.service;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {
    SecurityUser getUserFromRequest();
    boolean canAccessClient(UUID clientId);
    boolean canAccessCard(UUID cardId);
    boolean canAccessCard(Card card);
    boolean canAccessTransaction(UUID transactionId);
}
