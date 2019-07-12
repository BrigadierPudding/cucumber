package ci.training;

import java.util.HashMap;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepo;


public class Repository implements WalletRepo{
	
	private HashMap<String, Customer> customers;

	public Repository() {
		super();
	}
	
	public Repository(HashMap<String, Customer> map) {
		customers = map;
	}
	
	@Override
	public boolean save(Customer c) {
		customers.put(c.getPhoneNumber(), c);
		return true;
	}

	@Override
	public Customer find(String phoneNumber) {
		return customers.get(phoneNumber);
	}

}
