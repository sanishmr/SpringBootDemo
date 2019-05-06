package com.san.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.san.SpringBootDemo.model.Product;
import com.san.SpringBootDemo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	//@GetMapping(value = {"/product"}) // 
	@RequestMapping("/product")
	public String ShowProductsPage(Model model) {
		List<Product> listProducts = productService.findAllProducts();
		model.addAttribute("listProducts", listProducts);
		return "product";
	}
	
	//@GetMapping(value = { "/new"}) // 
	@RequestMapping("/new")
	public String ShowAddProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "add_product";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String SaveProduct(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/product";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView ShowEdiProductPage(@PathVariable(name="id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productService.searchById(id);
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable(name="id") Long id) {
		productService.removeProduct(id);
		return "redirect:/product";
	}



}
