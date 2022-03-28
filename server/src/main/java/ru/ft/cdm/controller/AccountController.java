package ru.ft.cdm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.ft.cdm.dto.AccountDto;
import ru.ft.cdm.dto.CardDto;
import ru.ft.cdm.entity.Account;
import ru.ft.cdm.service.AccountService;

@AllArgsConstructor
@RestController
public class AccountController {
    private AccountService accountService;

    @GetMapping("/account/{accountId}/getBalance")
    Long getBalance(@PathVariable Long accountId) {
        return accountService.getBalance(accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Account ID"));
    }

    @PostMapping("/account/getByCard")
    AccountDto getAccount(@RequestBody CardDto cardDto) {
        Account account = accountService.getAccount(cardDto.getNumber(), cardDto.getPin())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong PIN-code"));
        return new AccountDto(account.getId(), account.getBalance());
    }
}
