package ci.training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	Customer cust;
	Wallet wall;
	BigDecimal bal;
	WalletServiceImpl service;
	Repository repo;
	String resultName;
	BigDecimal resultBalance;
	
	
	@Given("i want to create an account")
	public void i_want_to_create_an_account() {
		repo = new Repository(new HashMap<String, Customer>());
		service = new WalletServiceImpl(repo);

		cust = service.createWallet("dummy", "555-555-5555", new BigDecimal(120));
	}

	@When("I pass {int}, {string}")
	public void i_pass(Integer int1, String string) {
		cust.getWallet().setBalance(new BigDecimal(int1));
		cust.setName(string);
	}

	@Then("I am given account with {int}, {string}")
	public void i_am_given_account_with(Integer int1, String string) {
		assertThat(string).isEqualTo(cust.getName());
	    assertThat(new BigDecimal(int1)).isEqualTo(cust.getWallet().getBalance());
	}
}
