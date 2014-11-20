/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import bits.ewallet.entity.Account;
import bits.ewallet.repository.AccountRepository;
import bits.ewallet.repository.ClientRepository;
import bits.ewallet.repository.TransactionRecordRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amit
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView accountDetails(@PathVariable("id") Account account){
		ModelAndView mav = new ModelAndView("/account/details");
		mav.addObject("account",account);
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody List<Account> searchAccounts(@RequestParam ("accountNumber") String query){

//		ModelAndView mav = new ModelAndView("/account/details");
		List<Account> accounts = accountRepository.findByAccountNumberContainingIgnoreCase(query, null);
		return accounts;
	}

}
