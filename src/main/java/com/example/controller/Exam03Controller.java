package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("input-products")
	public String inputProducts(Integer product1, Integer product2, Integer product3) {
		Integer planePrice = product1 + product2 + product3;
		Integer taxedPrice = Integer.valueOf((int) Math.floor(planePrice * 1.1));

		application.setAttribute("planePrice", planePrice);
		application.setAttribute("taxedPrice", taxedPrice);

		return "exam03-result";
	}

	@RequestMapping("result")
	public String result() {
		return "exam03-result";
	}

}
