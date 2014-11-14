/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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

	//if successful login, redirect to /client
	private final Logger logger = Logger.getLogger(AccessController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		logger.info("#login method called.");
		ModelAndView mav = new ModelAndView("/login/loginPage");
//		mav.addObject("success", success);
//		mav.addObject("failure", failure);
		return mav;

	}

}
