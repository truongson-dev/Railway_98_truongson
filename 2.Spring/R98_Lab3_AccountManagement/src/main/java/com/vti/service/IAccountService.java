package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService extends UserDetailsService {

	Page<Account> getAllAccount(Pageable pageable, String search);

	Account getAccountByID(short id);

	Account createAccount(AccountFormForCreating form);

	Account updateAccount(short id, AccountFormForUpdating form);

	void deleteAccount(short id);

	Account getAccountByEmail(String email);

}
