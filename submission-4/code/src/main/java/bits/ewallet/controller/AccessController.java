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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Value("${app.admin.username}")
	private String username;

	@Value("${app.admin.password}")
	private String password;

	//if successful login, redirect to /client
	private final Logger logger = Logger.getLogger(AccessController.class);

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam String username, @RequestParam String password) {
		if (this.username.equals(username) && this.password.equals(password)) {
			ModelAndView mav = new ModelAndView("/client/admin");
			List clients = clientRepository.findAll();
			int totalClients = clients.size();
			mav.addObject("clients", clients);
			mav.addObject("totalClients", totalClients);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("/login/incorrect");
			return mav;
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("/login/login");
		return mav;

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("/login/signup");
		Client client = new Client();
		List<Account> accounts = new ArrayList<Account>();
		client.setAccounts(accounts);
		mav.addObject("client", client);
		return mav;

	}

	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	public ModelAndView approval(@ModelAttribute Client client) {
		if (clientRepository.findByUsernameContainingIgnoreCase(client.getUsername(), null).isEmpty()) {
			clientRepository.save(client);
			ModelAndView mav = new ModelAndView("/login/approval");
			mav.addObject("username", client.getUsername());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("/login/duplicate");
			return mav;
		}

	}

}
