package com.matera.account.accounttype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
