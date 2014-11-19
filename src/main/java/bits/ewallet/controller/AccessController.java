/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.Client;
import bits.ewallet.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amit
 */
@Controller
@RequestMapping
public class AccessController {

	@Autowired
	private ClientRepository clientRepository;

	//if successful login, redirect to /client
	private final Logger logger = Logger.getLogger(AccessController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView mav = new ModelAndView("/login/login");
//		mav.addObject("success", success);
//		mav.addObject("failure", failure);
		return mav;

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup()
	{
		ModelAndView mav = new ModelAndView("/login/signup");
		Client client = new Client();
		List<Account> accounts = new ArrayList<Account>();
		client.setAccounts(accounts);
		mav.addObject("client", client);
		return mav;

	}

	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	public ModelAndView approval(@ModelAttribute Client client)
	{
		clientRepository.save(client);
		ModelAndView mav = new ModelAndView("/login/approval");
		mav.addObject("username", client.getUsername());
		return mav;

	}

}
