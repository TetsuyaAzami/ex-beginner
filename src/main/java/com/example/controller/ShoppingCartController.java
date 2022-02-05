package com.example.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import com.example.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex06")
public class ShoppingCartController {

	@Autowired
	private ServletContext application;

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String index(Model model) {
		// 商品一覧を格納
		if (application.getAttribute("itemList") == null) {
			List<Item> itemList = new LinkedList<>(Arrays.asList(new Item("手帳ノート", 1000),
					new Item("文房具セット", 1500), new Item("ファイル", 2000)));
			application.setAttribute("itemList", itemList);
		}

		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (LinkedList<Item>) session.getAttribute("cartItemList");

		Integer totalPrice = 0;
		// カートに空のリストを格納
		if (cartItemList == null) {
			session.setAttribute("cartItemList", new LinkedList<>());
		} else {
			// 空でない場合は合計金額を計算
			totalPrice = cartItemList.stream().mapToInt(item -> item.getPrice()).sum();
		}
		model.addAttribute("totalPrice", totalPrice);
		return "item-and-cart";
	}

	@RequestMapping("in-cart")
	public String inCart(Integer index, Model model) {
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
		Item item = itemList.get(index);
		cartItemList.add(item);
		session.setAttribute("cartItemList", cartItemList);
		return index(model);
	}

	@RequestMapping("delete")
	public String delete(int index, Model model) {
		System.out.println(index);
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
		cartItemList.remove(index);
		session.setAttribute("cartItemList", cartItemList);
		return index(model);
	}
}
