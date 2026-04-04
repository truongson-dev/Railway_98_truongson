package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AccountSpecification implements Specification<Account> {
	private String field;
	private String operator;
	private Object value;

	public AccountSpecification(String field, String operator, Object value) {
		super();
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (operator.equalsIgnoreCase("LIKE")) {

			if (field.equalsIgnoreCase("department.name")) {
				return builder.like(root.get("department").get("name"), "%" + value.toString() + "%");
			} else {
				return builder.like(root.get(field), "%" + value.toString() + "%");
			}
		}
		return null;

	}

}
