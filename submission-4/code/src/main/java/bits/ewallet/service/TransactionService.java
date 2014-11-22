/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.service;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.TransactionRecord;
import bits.ewallet.repository.AccountRepository;
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
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@Autowired
	private AccountService accountService;

	/**
	 *
	 * @param toAccount debit account to transfer amount to
	 * @param amount transaction amount
	 * @return saved transaction record with database id assigned
	 */
	public TransactionRecord saveTransaction(Account toAccount, double amount) {

		accountService.addBalanceAmount(toAccount, amount);
		TransactionRecord tr = new TransactionRecord();
		tr.setToAccount(toAccount);
		tr.setAmount(amount);
		toAccount.addToTransaction(tr);
		tr.setTransactionDate(new Date(new java.util.Date().getTime()));
		transactionRecordRepository.saveAndFlush(tr);
		accountRepository.saveAndFlush(toAccount);
		return tr;
	}

	/**
	 *
	 * @param fromAccount credit account to transfer money from
	 * @param toAccount debit account to transfer amount to
	 * @param amount transaction amount
	 * @return saved transaction record with database id assigned
	 */
	public TransactionRecord saveTransaction(Account fromAccount, Account toAccount, double amount) {

		TransactionRecord tr = new TransactionRecord();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setAmount(amount);
		fromAccount.addFromTransaction(tr);
		toAccount.addToTransaction(tr);
		tr.setTransactionDate(new Date(new java.util.Date().getTime()));
		if (accountService.checkBalance(fromAccount, amount)) {
			accountService.addBalanceAmount(toAccount, amount);
			accountService.addBalanceAmount(fromAccount, -amount);
			transactionRecordRepository.saveAndFlush(tr);
			accountRepository.saveAndFlush(toAccount);
			accountRepository.saveAndFlush(fromAccount);
		}
		return tr;
	}

	/**
	 *
	 * @param fromAccount credit account to transfer money from
	 * @param toAccount debit account to transfer amount to
	 * @param amount transaction amount
	 * @param pin identification key of credit account (fromAccount)
	 * @return saved transaction record with database id assigned
	 */
	public TransactionRecord saveTransaction(Account fromAccount, Account toAccount, double amount, String pin) {

		TransactionRecord tr = new TransactionRecord();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setAmount(amount);
		fromAccount.addFromTransaction(tr);
		toAccount.addToTransaction(tr);
		tr.setTransactionDate(new Date(new java.util.Date().getTime()));

		if (accountService.checkBalance(fromAccount, amount)) {
			if (fromAccount.getUniqueId() != null) {
				if (!fromAccount.getUniqueId().equals(pin)) {
					return tr;
				} else {
					accountService.addBalanceAmount(toAccount, amount);
					accountService.addBalanceAmount(fromAccount, -amount);
					transactionRecordRepository.saveAndFlush(tr);
					accountRepository.saveAndFlush(toAccount);
					accountRepository.saveAndFlush(fromAccount);
					return tr;
				}
			} else {
				accountService.addBalanceAmount(toAccount, amount);
				accountService.addBalanceAmount(fromAccount, -amount);
				transactionRecordRepository.saveAndFlush(tr);
				accountRepository.saveAndFlush(toAccount);
				accountRepository.saveAndFlush(fromAccount);
				return tr;
			}
		} else {
			return tr;
		}
	}
}
