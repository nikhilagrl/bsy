package com.m23.loginservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Service
public class ExpenseEnvelopeResponse {

	@Autowired
	private ExpenseEnvelope expenseEnvelope;
	
	private String viewName;

	
	@JsonProperty("ExpenseEnvelopes")
	@JsonPropertyOrder(alphabetic=true)
	public ExpenseEnvelope getExpenseEnvelope() {
		return expenseEnvelope;
	}

	public void setExpenseEnvelope(ExpenseEnvelope expenseEnvelope) {
		this.expenseEnvelope = expenseEnvelope;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
