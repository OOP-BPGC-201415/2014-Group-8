/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import bits.ewallet.repository.AccountRepository;
import bits.ewallet.repository.ClientRepository;
import bits.ewallet.repository.TransactionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ModelAndView adminList(){
		ModelAndView mav = new ModelAndView("client/admin");
		mav.addObject(clientRepository.findAll());
		return mav;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView employeeList(){
		ModelAndView mav = new ModelAndView("client/admin");
//		mav.addObject(clientRepository.findByClientType(ClientType.EMPLOYEE));
		return mav;
	}

	@RequestMapping(value = "/merchants", method = RequestMethod.GET)
	public ModelAndView merchantList(){
		ModelAndView mav = new ModelAndView("client/admin");
//		mav.addObject(clientRepository.findByClientType(ClientType.MERCHANT));
		return mav;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employeeDashBoard(){
		ModelAndView mav = new ModelAndView("client/employee");
//		mav.addObject(clientRepository.findOne(employee.getId()));
		return mav;
	}

	@RequestMapping(value = "/merchant", method = RequestMethod.GET)
	public @ResponseBody ModelAndView merchantDashBoard(){
		ModelAndView mav = new ModelAndView("client/merchant");
//		mav.addObject(clientRepository.findOne(merchant.getId()));
		return mav;
	}

}
