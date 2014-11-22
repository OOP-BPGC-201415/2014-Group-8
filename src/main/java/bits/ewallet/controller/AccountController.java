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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/traccount", method = RequestMethod.POST)
	public ModelAndView accountDetails(@RequestParam("account") Account account) {
		ModelAndView mav = new ModelAndView("/account/details");
		List<Account> accounts = accountRepository.findAll();
		mav.addObject("accounts", accounts);
		mav.addObject("account", account);
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView searchAccounts(@RequestParam("accountNumber") String query, @RequestParam("accountId") Account account) {

		ModelAndView mav = new ModelAndView("/account/transaction");
		List<Account> allAccounts = accountRepository.findByAccountNumberContainingIgnoreCase(query, new Sort(Sort.Direction.ASC, "accountNumber"));
		if (!allAccounts.isEmpty()) {
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(allAccounts.get(0));
			mav.addObject("accounts", accounts);
		}
		mav.addObject("account", account);
		return mav;
	}

}
