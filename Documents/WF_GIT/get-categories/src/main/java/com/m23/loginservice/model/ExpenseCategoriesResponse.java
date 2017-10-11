package com.m23.loginservice.model;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class ExpenseCategoriesResponse {

	private ArrayList<ExpenseCategories> expenseCategories;

	private String viewName;

	@JsonProperty("ExpenseCategories")
	public ArrayList<ExpenseCategories> getExpenseCategories() {
		return expenseCategories;
	}

	public void setExpenseCategories(ArrayList<ExpenseCategories> expenseCategories) {
		this.expenseCategories = expenseCategories;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
