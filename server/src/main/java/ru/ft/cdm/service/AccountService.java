package ru.ft.cdm.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ft.cdm.entity.Account;
import ru.ft.cdm.repository.AccountRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountService {
    private AccountRepository accountRepository;

    public Optional<Long> getBalance(Long accountId) {
        return accountRepository.getBalanceById(accountId);
    }

    public Optional<Account> getAccount(Long number, Short pin) {
        return accountRepository.findAccountByCard(number, pin);
    }
}
