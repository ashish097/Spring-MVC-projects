package com.val.controller;

import javax.validation.Valid;

/*import org.apache.log4j.Logger;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
/*import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndView;

import com.val.model.Customer;


@Controller
public class SignUpController {

	/*private static final Logger logger = Logger.getLogger(SignUpController.class);*/
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") @Valid Customer customer,BindingResult result,Model model) {
		
		
		/*if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));*/

		if (result.hasErrors()) {
			
			 return "SignUpForm";

		} 
		
		  model.addAttribute("name", customer.getName());
	      model.addAttribute("age", customer.getAge());
	      //model.addAttribute("id", customer.getId());
	  
	      return "Done";	

	}
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String displayCustomerForm(Model model) {

		model.addAttribute("customer", new Customer());
		return "SignUpForm";

	}
	  /* @ModelAttribute("customer")
	   public Customer createCustomerModel() {	
	      return new Customer();
	   }

	@RequestMapping(value = "/signup",method = RequestMethod.GET)
	public ModelAndView customer() {
		return new ModelAndView("signup","command", new Customer());

	}*/

}