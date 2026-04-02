package com.vti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
	Optional<Account> findByEmail(String email);

	Optional<Account> findByUsername(String username);

	Optional<Account> findByUsernameOrEmail(String username, String email);

	Optional<Account> findByUsernameAndEmail(String username, String email);
}
