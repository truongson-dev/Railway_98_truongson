package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccontDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Account> pageAccounts = accountService.getAllAccount(pageable, search);

//		List<AccontDto> listaAccontDtos = new ArrayList<>();
//		for (Account account : listaAccounts) {
//			AccontDto accontDto = new AccontDto();
//			accontDto.setId(account.getId());
//			accontDto.setEmail(account.getEmail());
//			accontDto.setFullname(account.getFullname());
//			accontDto.setUsername(account.getUsername());
//			accontDto.setDepartment(account.getDepartment().getName());
//			accontDto.setPosition(account.getPosition().getName().toString());
//			accontDto.setCreateDate(account.getCreateDate());
//
//			listaAccontDtos.add(accontDto);
//		}

		Page<AccontDto> pageAccountDtos = pageAccounts.map(new Function<Account, AccontDto>() {

			@Override
			public AccontDto apply(Account account) {
				AccontDto accontDto = new AccontDto();
				accontDto.setId(account.getId());
				accontDto.setEmail(account.getEmail());
				accontDto.setFullname(account.getFullname());
				accontDto.setUsername(account.getUsername());
				accontDto.setDepartment(account.getDepartment().getName());
				accontDto.setPosition(account.getPosition().getName().toString());
				accontDto.setCreateDate(account.getCreateDate());
				return accontDto;
			}
		});

		return new ResponseEntity<>(pageAccountDtos, HttpStatus.OK);
	}

//	Tìm kiếm Account theo ID
//	http://localhost:8081/api/v1/accounts/1
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.getAccountByID(id);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setFullname(account.getFullname());
		accontDto.setUsername(account.getUsername());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());
		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

//	Tìm kiếm Account theo Email
//	http://localhost:8080/api/v1/accounts/email/daonq@gmail.com
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<?> getAccountByEmail(@PathVariable(name = "email") String email) {
		Account account = accountService.getAccountByEmail(email);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setFullname(account.getFullname());
		accontDto.setUsername(account.getUsername());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());
		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

//	Tạo mới Account
	@PostMapping
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		Account account = accountService.createAccount(form);
		AccontDto accontDto = new AccontDto();

		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setFullname(account.getFullname());
		accontDto.setUsername(account.getUsername());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

// Cập nhật Account
//	http://localhost:8081/api/v1/accounts/1
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdating form) {
		Account account = accountService.updateAccount(id, form);
		AccontDto accontDto = new AccontDto();

		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setFullname(account.getFullname());
		accontDto.setUsername(account.getUsername());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

	// Xóa Account
//		http://localhost:8081/api/v1/accounts/5
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
	}

}
