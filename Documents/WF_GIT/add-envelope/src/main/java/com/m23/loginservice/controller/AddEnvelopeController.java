package com.m23.loginservice.controller;

import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m23.loginservice.model.ExpenseEnvelope;
import com.m23.loginservice.model.ExpenseEnvelopeRequest;
import com.m23.loginservice.model.ExpenseEnvelopeResponse;


@RestController
@RequestMapping(value = AddEnvelopeController.CONTRACT_BASE_URI)
public class AddEnvelopeController {

	public static final String CONTRACT_BASE_URI = "/cashflow/v1/reserve/envelope";
	protected Logger logger = Logger.getLogger(AddEnvelopeController.class.getName());

	@Autowired
	ExpenseEnvelope expenseEnvelope;



	@Autowired
	ExpenseEnvelopeResponse expenseEnvelopeResponse;

	@RequestMapping(value = "/envelopes", method = RequestMethod.POST)
	public ResponseEntity<Object> addEnvelope(@RequestBody ExpenseEnvelopeRequest expenseEnvelopeRequest, HttpServletResponse response)
	{

		expenseEnvelope();
		expenseEnvelopeResponse();


		return new ResponseEntity<Object>(expenseEnvelopeResponse, HttpStatus.OK);

		
	}



	private void expenseEnvelopeResponse() {
		expenseEnvelopeResponse.setExpenseEnvelope(expenseEnvelope);
		expenseEnvelopeResponse.setViewName("envelopes");
	}



	private void expenseEnvelope() {
		expenseEnvelope.setAllocatedAmount("allocatedAmount");
		expenseEnvelope.setAmountType("amountType");
		expenseEnvelope.setBillDisplayMessage("billDisplayMessage");
		expenseEnvelope.setBillStatus("billStatus");
		expenseEnvelope.setDueAmount("dueAmount");
		expenseEnvelope.setDueDate("dueDate");
		expenseEnvelope.setDueDays("dueDays");
		expenseEnvelope.setEnvelopeKeyName("envelopeKeyName");
		expenseEnvelope.setEnvelopeName("envelopeName");
		expenseEnvelope.setFrequency("frequency");
		expenseEnvelope.setPayOnDate("payOnDate");
		expenseEnvelope.setRemaingingDueAmount("remaingingDueAmount");
		expenseEnvelope.setSuperPayEligible(true);
		expenseEnvelope.setType("type");
	}

}
