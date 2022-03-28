package ru.ft.cdm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ft.cdm.entity.Account;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("select balance from Account where id = :id")
    Optional<Long> getBalanceById(Long id);

    @Query("select a from Account a left join Card c on a.id = c.account.id where c.id = :id and c.pinCode = :pinCode")
    Optional<Account> findAccountByCard(Long id, Short pinCode);
}
