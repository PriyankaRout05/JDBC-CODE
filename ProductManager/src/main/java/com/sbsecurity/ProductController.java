package com.sbsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@Autowired
	private ProductService Service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model ){
		List<Product> listProducts = Service.listAll();
		model.addAttribute("listProducts",listProducts);
		return"index";	
	}
	@RequestMapping("/new")
	public String showNewProductFrom(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		return"new_object";
		
	}
	
	

}
