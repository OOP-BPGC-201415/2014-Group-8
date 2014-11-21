/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.service;

import bits.ewallet.entity.Account;
import bits.ewallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amit
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

/**
 *
 * @param account account to which amount is to be added
 * @param amount transfer amount
 */
	public void addBalanceAmount(Account account, double amount){
		account.setBalance(account.getBalance()+amount);
		accountRepository.saveAndFlush(account);
	}

/**
 *
 * @param account account whose balance needs to be checked (credit account)
 * @param amount amount to be checked
 * @return true if balance greater than amount and false if balance less than amount
 */
	public boolean checkBalance(Account account, double amount){

		if(account.getBalance() >= amount){
			return true;
		}else{
			return false;
		}
	}

/**
 *
 * @return string formatted account number corresponding to sequence value
 */
	public String getAccountNumber(){
		long accNum;
		String prefix = Account.prefix;
		Object[] num = accountRepository.findSequenceValue();
		accNum = Long.parseLong(num[0].toString()) + 1;
		return prefix + String.format("%05d", accNum);
	}

}
