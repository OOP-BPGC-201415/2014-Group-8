/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.TransactionRecord;
import bits.ewallet.repository.AccountRepository;
import bits.ewallet.repository.TransactionRecordRepository;
import bits.ewallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amit
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "/credit", method = RequestMethod.GET)
	public ModelAndView creditTransaction(@RequestParam("balance") Double balance, @RequestParam("account") Account account, @RequestParam("acc") Account acc) {
		TransactionRecord tr = transactionService.saveTransaction(account, acc, balance);
		if (tr.getId() != null) {
			ModelAndView mav = new ModelAndView("transaction/success");
			mav.addObject("transaction", tr);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("transaction/failure");
			mav.addObject("transaction", tr);
			return mav;
		}
	}

	@RequestMapping(value = "/debit/{id}", method = RequestMethod.GET)
	public ModelAndView rechargeAccount(@RequestParam("amount") Double amount, @PathVariable("id") Account account) {
		TransactionRecord tr = transactionService.saveTransaction(account, amount);
		if (tr.getId() != null) {
			ModelAndView mav = new ModelAndView("transaction/success");
			mav.addObject("transaction", tr);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("transaction/failure");
			mav.addObject("transaction", tr);
			return mav;
		}

	}

	@RequestMapping(value = "/debit", method = RequestMethod.GET)
	public ModelAndView debitTransaction(@RequestParam("balance") Double balance, @RequestParam("pin") String pin, @RequestParam("account") Account account, @RequestParam("acc") Account acc) {

		TransactionRecord tr = transactionService.saveTransaction(acc, account, balance, pin);
		if (tr.getId() != null) {
			ModelAndView mav = new ModelAndView("transaction/success");
			mav.addObject("transaction", tr);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("transaction/failure");
			mav.addObject("transaction", tr);
			return mav;
		}
	}

}
