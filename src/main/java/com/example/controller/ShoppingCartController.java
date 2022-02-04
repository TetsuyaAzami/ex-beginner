package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex06")
public class ShoppingCartController {

	@Autowired
	private ServletContext application;

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String index() {
		return "item-and-cart";
	}

	@RequestMapping("inCart")
	public String inCart() {
		return index();
	}

	@RequestMapping("delete")
	public String delete() {
		return index();
	}
}
