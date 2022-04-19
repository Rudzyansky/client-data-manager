package ru.ft.cdm.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import ru.ft.cdm.dto.AccountDto;
import ru.ft.cdm.dto.CardDto;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping
public class AccountController {
    private RestTemplate restTemplate;

    @GetMapping("/account/{accountId}/getBalance")
    Long getBalance(@PathVariable Long accountId) {
        try {
            return restTemplate.getForObject(
                    "http://localhost:9000/account/{id}/getBalance", Long.class, accountId);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Account ID");
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Service unavailable");
        }
    }

    @PostMapping("/account/getByCard")
    AccountDto getAccount(@RequestBody CardDto card) {
        try {
            return restTemplate.postForObject(
                    "http://localhost:9000/account/getByCard", card, AccountDto.class);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong PIN-code");
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Service unavailable");
        }
    }
}
