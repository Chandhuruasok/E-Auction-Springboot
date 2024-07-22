package com.chainsys.eauction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.eauction.dao.UserDAO;

import com.chainsys.eauction.model.Users;
import com.chainsys.eauction.validation.Validation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuctionController {
	@Autowired
	UserDAO userDao;
	@Autowired
	Validation validation;
	@RequestMapping("/")
	public String homePage() {
		return "homePage.jsp";
	}

	@PostMapping("/register")
	public String register(@RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("phonenumber") String phoneNumber, @RequestParam("password") String password,Model model) {
		if (!validation.validateEmail(email)) {
            model.addAttribute("error", "Invalid email format");
            return "register.jsp";
        }
		
		if (!validation.validateUsername(name)) {
            model.addAttribute("error", "Invalid username format");
            return "register.jsp";
            
        }
        
        
		if(!validation.validateMobile(phoneNumber))
        {
        	model.addAttribute("error", "Invalid mobile number");
        	return "register.jsp";
        }
        if (!validation.validatePassword(password)) {
            model.addAttribute("error", "Password format wrong");
            return "register.jsp";
        }
        
				Users users = new Users();
				users.setEmail(email);
				users.setName(name);
				users.setPhoneNumber(phoneNumber);
				users.setPassword(password);

		if(userDao.register(users))
		{

		return "homePage.jsp";
		}
		return "login.jsp";
		
			
			
		
	}
			
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("username") String name,@RequestParam("password") String password,HttpSession session,Model model) {
		if (!validation.validateEmail(email)) {
            model.addAttribute("error", "Invalid email format");
            return "login.jsp";
        }
		
		if (!validation.validateUsername(name)) {
            model.addAttribute("error", "Invalid username format");
            return "login.jsp";
            
        }
        
        
       
        if (!validation.validatePassword(password)) {
            model.addAttribute("error", "Password format wrong");
            return "login.jsp";
        }
				Users user = new Users();
				user.setEmail(email);
				user.setName(name);
				user.setPassword(password);
				
                if(userDao.login(user))
                {
                	Users userId=userDao.getUserId(email);
                	session.setAttribute("userid",userId);
                    session.setAttribute("username", userId.getName());
                	
                    if(email.endsWith("@bidderboy.com")) 
                    {
                      return "admin.jsp";
                    }
                    else if(email.endsWith("@seller.com"))
                    {
                    	  return "sellerProducts.jsp";
                    }
                    else if(email.endsWith("@gmail.com"))
                    {
                    	  return "biddersViewProducts.jsp";
                    }
                }
                
                	return "register.jsp";
			

}
	@GetMapping("logout")
    public String logoutUser(HttpSession session,HttpServletRequest request) {
        session = request.getSession(false);
        if (session != null) {
               session.invalidate(); 
           }

        
       return "login.jsp";
        
    }
}
