package ci.training;

import java.util.HashMap;
import java.util.Map;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepo;


public class Repository implements WalletRepo{
	
	private HashMap<String, Customer> customers;

	public Repository() {
		super();
	}
	
	public Repository(Map<String, Customer> map) {
		customers = (HashMap<String, Customer>) map;
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
