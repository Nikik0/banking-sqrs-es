package com.nikik0.banking.web.security.service;

import com.nikik0.banking.domain.exception.ResourceNotFoundException;
import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.service.card.CardService;
import com.nikik0.banking.service.client.ClientService;
import com.nikik0.banking.service.transaction.TransactionService;
import com.nikik0.banking.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{

    private final ClientService clientService;

    private final CardService cardService;

    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.isAuthenticated()){
            return null;
        }
        if (auth.getPrincipal().equals("anonymousUser")){
            return null;
        }
        return (SecurityUser) auth.getPrincipal();
    }

    @Override
    public boolean canAccessClient(UUID clientId) {
        SecurityUser user = getUserFromRequest();
        return clientId.equals(user.getId());
    }

    @Override
    public boolean canAccessCard(UUID cardId) {
        SecurityUser user = getUserFromRequest();
        Client client = clientService.getById(user.getId());
        return client.getCards().stream().anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(Card card) {
        try{
            Card foundCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );
            return canAccessCard(foundCard.getId());
        }catch (ResourceNotFoundException exception){
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        Client client = clientService.getById(user.getId());
        Transaction transaction = transactionService.getById(transactionId);
        return client.getCards().contains(transaction.getTo()) ||
                client.getCards().contains(transaction.getFrom());
    }
}
