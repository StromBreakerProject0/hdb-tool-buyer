package com.hdbtool.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);
		
	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable(name = "id") Long id) {
//		service.delete(id);
//		
//		return "redirect:/list";
//	}

}
