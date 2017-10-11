package com.m23.addcategoriesservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Service
@JsonPropertyOrder
public class ExpenseCategoryResponse {

	@Autowired
	private ExpenseCategory expenseCategory;

	private String viewName;

	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	@JsonProperty("ExpenseCategory")
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
