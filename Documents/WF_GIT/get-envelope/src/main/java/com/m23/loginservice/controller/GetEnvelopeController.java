package com.m23.loginservice.controller;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m23.loginservice.model.Envelope;
import com.m23.loginservice.model.ExpenseEnvelope;
import com.m23.loginservice.model.PayeeDetails;

@RestController
@RequestMapping(value = GetEnvelopeController.CONTRACT_BASE_URI)
public class GetEnvelopeController {

	public static final String CONTRACT_BASE_URI = "/cashflow/v1/reserve/envelope";
	protected Logger logger = Logger.getLogger(GetEnvelopeController.class.getName());

	@Autowired
	Envelope envelope;

	@Autowired
	ExpenseEnvelope expenseEnvelope;

	@Autowired
	PayeeDetails payeeDetails;

	@Autowired
	private HttpServletRequest request;

	private static final String HEADER_STRING = "Authorization";

	@RequestMapping(value = "/envelopes", method = RequestMethod.GET)
	public Envelope getEnvelopesId(HttpServletResponse response) throws Exception {

		payeeDetails();
		expenseEnvelope();
		envelope();
		return envelope;

	}

	private void envelope() {

		ArrayList<ExpenseEnvelope> expenseEnvelopeList = new ArrayList<ExpenseEnvelope>();
		expenseEnvelopeList.add(expenseEnvelope);
		envelope.setExpenseEnvelope(expenseEnvelopeList);
		envelope.setViewName("envelopes");
	}

	private void expenseEnvelope() {
		expenseEnvelope.setAllocatedAmount("allocatedAmount");
		expenseEnvelope.setAmountType("amountType");
		expenseEnvelope.setBillDisplayMessage("billDisplayMessage");
		expenseEnvelope.setBillStatus("billStatus");
		expenseEnvelope.setDueAmount("dueAmount");
		expenseEnvelope.setDueDate("dueDate");
		expenseEnvelope.setDueDays("dueDays");
		expenseEnvelope.setEnvelopeName("envelopeName");
		expenseEnvelope.setFrequency("frequency");
		expenseEnvelope.setPayeeDetails(payeeDetails);
		expenseEnvelope.setPayeeType("payeeType");
		expenseEnvelope.setPayOnDate("payOnDate");
		expenseEnvelope.setRemaingingDueAmount("remaingingDueAmount");
		expenseEnvelope.setSuperPayEligible(true);
		expenseEnvelope.setType("type");
	}

	private void payeeDetails() {
		payeeDetails.setAccountNumber("accountNumber");
		payeeDetails.setAddress1("accountNumber");
		payeeDetails.setBillFirstName("accountNumber");
		payeeDetails.setBillLastName("accountNumber");
		payeeDetails.setBillpayDays("accountNumber");
		payeeDetails.setCity("accountNumber");
		payeeDetails.setEbillActive(true);
		payeeDetails.setEbillAvailable(true);
		payeeDetails.setEbillEligible(true);
		payeeDetails.setEbillTermsDisplayInternal(true);
		payeeDetails.setEbillToken1("accountNumber");
		payeeDetails.setNewEbillAvailable(true);
		payeeDetails.setPayeeLoaded(true);
		payeeDetails.setPayeeName("payeeName");
		payeeDetails.setPhoneNumber("phoneNumber");
		payeeDetails.setState("state");
	}

}
