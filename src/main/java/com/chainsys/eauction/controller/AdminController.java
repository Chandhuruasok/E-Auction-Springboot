package com.chainsys.eauction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.eauction.dao.UserDAO;
import com.chainsys.eauction.model.Sellers;


@Controller
public class      AdminController {
	
	@Autowired
	UserDAO user;
	@Autowired
	Sellers sellers;
	
	@PostMapping("/rejectsellerproducts")
	public String rejectSellerProducts(@RequestParam("deleteproductid") int productId)
	{
		user.adminRejectSellerProduct(productId);
		
		return "admin.jsp";
	}
	@PostMapping("/approvesellerproducts")
	public String approveSellerProducts(@RequestParam("approveproductid") int productId)
	{
		user.adminApproveSellerProduct(productId);
		
		return "admin.jsp";
	}
	@GetMapping("/viewapprovedproducts")
	public String viewApprovedProducts(Model model)
	{
		List<Sellers> approvedProducts=null;
		approvedProducts=user.adminViewApprovedProducts();
		
		model.addAttribute("approvedProducts",approvedProducts);
		return "adminViewProducts.jsp";
	}
	@PostMapping("/viewbidders")
	public String viewBiddersBidAmount(@RequestParam("productname") String productName,Model model)
	{
		  model.addAttribute("productName", productName);
		  
	      return "adminViewBidders.jsp";
	}
	@PostMapping("/adminViewWinners")
	public String adminViewWinners(@RequestParam("productname") String productName,Model model)
	{
		  model.addAttribute("productName", productName);
		  
	      return "adminViewWinners.jsp";
	}
	
}
