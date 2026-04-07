package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPossitionRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IPossitionRepository possitionRepository;

	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
//		Where
		Specification<Account> where = null;

//			fullname like search
//		or	email like seach
//		or  department like search
		if (!StringUtils.isEmpty(search)) {
			AccountSpecification fullnameSpecification = new AccountSpecification("fullname", "LIKE", search);
			AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
			AccountSpecification departmentSpecification = new AccountSpecification("department", "LIKE", search);

			where = Specification.where(fullnameSpecification).or(emailSpecification).or(departmentSpecification);
		}

		return accountRepository.findAll(where, pageable);
	}

	@Override
	public Account getAccountByID(short id) {
		// TODO Auto-generated method stub
		return accountRepository.getById(id);
	}

	@Override
	public Account createAccount(AccountFormForCreating form) {
		Account account = new Account();
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullname(form.getFullname());

//		Từ id phòng ban==> tìm ra được phòng ban tương ứng: form.getDepartmentId()
		Department department = departmentRepository.getById(form.getDepartmentId());
		account.setDepartment(department);

//		Từ id phòng ban==> tìm ra được phòng ban tương ứng: form.getDepartmentId()
		Position position = possitionRepository.getById(form.getPositionId());
		account.setPosition(position);

		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(short id, AccountFormForUpdating form) {
		Account account = accountRepository.getById(id);

		account.setFullname(form.getFullname());
		Department department = departmentRepository.getById(form.getDepartmentId());
		account.setDepartment(department);

		Position position = possitionRepository.getById(form.getPositionId());
		account.setPosition(position);

		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accountRepository.findByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException("Account not found with email = " + email));

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account_db = accountRepository.findByUsername(username);
		if (account_db == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(account_db.getUsername(), account_db.getPassword(), AuthorityUtils.createAuthorityList("user"));
	}

}
