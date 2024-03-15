package com.nikik0.banking.web.controller;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.service.card.CardService;
import com.nikik0.banking.web.dto.CardDto;
import com.nikik0.banking.web.dto.TransactionDto;
import com.nikik0.banking.web.security.SecurityUser;
import com.nikik0.banking.web.security.service.SecurityService;
import com.nikik0.banking.web.dto.mapper.CardMapper;
import com.nikik0.banking.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final SecurityService securityService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(){
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByUserId(user.getId());
    }

    @GetMapping("/{cardId}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(@PathVariable UUID cardId){
        Card card = cardService.getById(cardId);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{cardId}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID cardId){
        Card card = cardService.getById(cardId);
        return transactionMapper.toDto(card.getTransactions());
    }
}
