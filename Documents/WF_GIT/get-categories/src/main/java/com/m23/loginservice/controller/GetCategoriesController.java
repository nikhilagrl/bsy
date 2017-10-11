package com.m23.loginservice.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m23.loginservice.model.ExpenseCategories;
import com.m23.loginservice.model.ExpenseCategoriesResponse;


@RestController
@RequestMapping(value = GetCategoriesController.CONTRACT_BASE_URI)
public class GetCategoriesController {

	public static final String CONTRACT_BASE_URI = "/cashflow/v1/reserve/envelope";
	protected Logger logger = Logger.getLogger(GetCategoriesController.class.getName());

	@Autowired
	ExpenseCategories expenseCategories;

	@Autowired
	ExpenseCategoriesResponse expenseCategoriesResponse;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<Object> getCategory(@CookieValue(value = "OREP_COOKIE", defaultValue = "0") Long OREP_COOKIE,
			HttpServletResponse response)
	{
		creatingExpenseCategories();
		createingExpenseCategoriesResponse();
		creatingCookie(OREP_COOKIE, response);

		return new ResponseEntity<Object>(expenseCategoriesResponse, HttpStatus.OK);
	}

	public void createingExpenseCategoriesResponse() {
		ArrayList<ExpenseCategories> expenseCategoriesList = new ArrayList<ExpenseCategories>();
		expenseCategoriesList.add(expenseCategories);
		expenseCategoriesResponse.setExpenseCategories(expenseCategoriesList);
		expenseCategoriesResponse.setViewName("");
	}

	private void creatingExpenseCategories() {
		expenseCategories.setName("Rent");
		expenseCategories.setPriority("1");
		expenseCategories.setType("Expenses");
		expenseCategories.setUserdefined(false);
		expenseCategories.setUtilized(false);
	}

	private void creatingCookie(Long OREP_COOKIE, HttpServletResponse response) {
		OREP_COOKIE++;
		Cookie cookie = new Cookie("OREP_COOKIE", OREP_COOKIE.toString());
		response.addCookie(cookie);
	}
}
