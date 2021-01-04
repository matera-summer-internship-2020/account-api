package com.matera.account.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAllByClientId(UUID clientId);

    @Query("SELECT acct FROM Account acct WHERE acct.accountId = :accountId AND acct.clientId = :clientId")
    Optional<Account> findByAccountIdAndClientId(@Param("clientId") UUID clientId, @Param("accountId") UUID accountId);


}
