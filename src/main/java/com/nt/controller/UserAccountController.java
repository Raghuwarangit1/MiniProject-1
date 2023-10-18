package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.UserAccount;
import com.nt.service.IUserAccountService;


@Controller
//Sever side validationes is pending 
public class UserAccountController {
	@Autowired
	private IUserAccountService service;
	

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("user", new UserAccount());
		
		return "index";
	}// index

	@PostMapping("/add-user")
	public String fetchAll(@ModelAttribute("user") UserAccount us, RedirectAttributes model, BindingResult error) {
		
	
		String upsert = service.upsert(us);
		model.addFlashAttribute("userresult", upsert);
		return "redirect:./";
	}// add

	@GetMapping("/allusers")
	public String getAll(Model model) {

		model.addAttribute("usersresult", service.findAllUsers());
		return "viewall";
	}// alluser

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {

		try {
			model.addAttribute("user", service.findUserById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";

	}// edit
	

	@GetMapping("/delete")
	public String delete(@RequestParam int id, RedirectAttributes model) {

		try {
			model.addFlashAttribute("deleteresult", service.hordDeleteById(id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:/allusers";
	}// delete

	@GetMapping("/status")
	public String changeStatus(@RequestParam("id") Integer id, @RequestParam("status") String status,
			RedirectAttributes model) {

		try {
			model.addFlashAttribute("statusresult", service.udateStatus(id, status));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:/allusers";
	}// statusupdate

	@GetMapping("/contact")
	public String contact() {
		return "contactinfo";
	}
}// class
