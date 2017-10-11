package com.m23.loginservice.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class Envelope {

	private ArrayList<ExpenseEnvelope> expenseEnvelope;

	private String viewName;

	@JsonProperty("ExpenseEnvelope")
	public ArrayList<ExpenseEnvelope> getExpenseEnvelope() {
		return expenseEnvelope;
	}

	public void setExpenseEnvelope(ArrayList<ExpenseEnvelope> expenseEnvelope) {
		this.expenseEnvelope = expenseEnvelope;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
