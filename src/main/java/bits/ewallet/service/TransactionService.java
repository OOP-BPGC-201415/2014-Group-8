/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.service;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.TransactionRecord;
import bits.ewallet.repository.TransactionRecordRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amit
 */
@Service
public class TransactionService {

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@Autowired
	private AccountService accountService;

	public TransactionRecord saveTransaction(Account toAccount, double amount) {

		accountService.addBalanceAmount(toAccount, amount);
		TransactionRecord tr = new TransactionRecord();
		tr.setToAccount(toAccount);
		tr.setAmount(amount);
		tr.setTransactionDate(new Date(new java.util.Date().getTime()));
		transactionRecordRepository.saveAndFlush(tr);
		return tr;
	}

	public TransactionRecord saveTransaction(Account fromAccount, Account toAccount, double amount) {

		TransactionRecord tr = new TransactionRecord();
		if (accountService.checkBalance(fromAccount, amount)) {
			accountService.addBalanceAmount(toAccount, amount);
			accountService.addBalanceAmount(fromAccount, -amount);
			tr.setFromAccount(fromAccount);
			tr.setToAccount(toAccount);
			tr.setAmount(amount);
			tr.setTransactionDate(new Date(new java.util.Date().getTime()));
			transactionRecordRepository.saveAndFlush(tr);
		}
		return tr;
	}

	public TransactionRecord saveTransaction(Account fromAccount, Account toAccount, double amount, String pin) {

		TransactionRecord tr = new TransactionRecord();
		if (accountService.checkBalance(fromAccount, amount)) {
			tr.setFromAccount(fromAccount);
			tr.setToAccount(toAccount);
			tr.setAmount(amount);
			tr.setTransactionDate(new Date(new java.util.Date().getTime()));
			transactionRecordRepository.saveAndFlush(tr);
		}
		return tr;
	}
}
