/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.service;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.Client;
import bits.ewallet.repository.AccountRepository;
import bits.ewallet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amit
 */
@Service
public class ClientService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AccountService accountService;

/**
 *
 * @param client client to whom a new account needs to be assigned
 * @return client with account added to his name
 */
	public Client addAccount(Client client){
		Account a = new Account();
		a.setAccountNumber("aa");
		a.setBalance(0.0);
		a.setClient(client);
		client.addAccount(a);
		a.setAccountNumber(accountService.getAccountNumber());
		accountRepository.saveAndFlush(a);
		clientRepository.saveAndFlush(client);
		return client;
	}
/**
 *
 * @param client client whose total balance is to be viewed
 * @return total balance across all accounts for this client
 */
	public double getTotalBalance(Client client){
		double balance = 0;
		for(Account a : client.getAccounts()){
			balance += a.getBalance();
		}
		return balance;
	}

}
