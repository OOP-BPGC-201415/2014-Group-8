/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.Client;
import bits.ewallet.repository.AccountRepository;
import bits.ewallet.repository.ClientRepository;
import bits.ewallet.repository.TransactionRecordRepository;
import bits.ewallet.service.ClientService;
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
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@Autowired
	private ClientService clientService;

	//admin dashboard
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminList() {
		ModelAndView mav = new ModelAndView("client/admin");
		List clients = clientRepository.findAll();
		int totalClients = clients.size();
		mav.addObject("clients", clients);
		mav.addObject("totalClients", totalClients);
		return mav;
	}

	//dashboard of client on login
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public ModelAndView dashboard(@RequestParam String username, @RequestParam String password) {
		ModelAndView mav = new ModelAndView("client/dashboard");
		List<Client> clients = clientRepository.findByUsername(username);
		if (clients.get(0).getPassword().equals(password)) {
			double balance = clientService.getTotalBalance(clients.get(0));
			mav.addObject("client", clients.get(0));
			mav.addObject("balance", balance);
		}
		return mav;
	}

//	@RequestMapping(value = "/{id}/dashboard", method = RequestMethod.GET)
//	public @ResponseBody
//	ModelAndView clientDashboard(@PathVariable("id") Client client) {
//
//		ModelAndView mav = new ModelAndView("client/dashboard");
//		double balance = clientService.getTotalBalance(client);
//		mav.addObject("client", client);
//		mav.addObject("balance", balance);
//		return mav;
//	}

	//called by button on admin page to add account to client
	@RequestMapping(value = "/{id}/account", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView assignAccount(@PathVariable("id") Client client) {
		ModelAndView mav = new ModelAndView("client/admin");
		clientService.addAccount(client);
		List<Client> clients = clientRepository.findAll();
		int totalClients = clients.size();
		mav.addObject("clients", clients);
		mav.addObject("totalClients", totalClients);
		return mav;
	}

	//client dashboard viewed by admin
	@RequestMapping(value = "/{id}/dashboard", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView viewClient(@PathVariable("id") Client client) {
		ModelAndView mav = new ModelAndView("client/dashview");
		List<Account> accounts = accountRepository.findByClient(client, null);
		double balance = clientService.getTotalBalance(client);
		mav.addObject("client", client);
		mav.addObject("accounts", accounts);
		mav.addObject("balance", balance);
		return mav;
	}

//	@RequestMapping(value = "/employee", method = RequestMethod.GET)
//	public ModelAndView employeeDashBoard(){
//		ModelAndView mav = new ModelAndView("client/employee");
////		mav.addObject(clientRepository.findOne(employee.getId()));
//		return mav;
//	}
//
//	@RequestMapping(value = "/merchant", method = RequestMethod.GET)
//	public @ResponseBody ModelAndView merchantDashBoard(){
//		ModelAndView mav = new ModelAndView("client/merchant");
////		mav.addObject(clientRepository.findOne(merchant.getId()));
//		return mav;
//	}
}
