package com.example.demo.Controller;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.*;
	import com.example.demo.Repository.LoginRepository;

	import jakarta.servlet.http.HttpSession;
	import jakarta.websocket.Session;
import org.springframework.web.bind.annotation.RequestParam;


	@Controller
	public class LoginController {
		
		@Autowired
		
		LoginRepository repo ;
		
		@RequestMapping("/welcome")
		public String Welcome() {
			return "Welcome";
		}
		
		@GetMapping("/")
		public String welcome(Model m) {
			List<LoginModel> li =(List<LoginModel>) repo.findAll();//tablename
			m.addAttribute("add-products",li);
			return "home";
		}
		@GetMapping("/getbyid/{id}")
		public String getbyid(@PathVariable(value="id") int id,Model m) {
			Optional<LoginModel> v = repo.findById(id);
			LoginModel c = v.get();
			m.addAttribute("products",c);
			return "edit";
	}
		@PostMapping("/save_products")
		public String insert(@ModelAttribute LoginModel m, HttpSession session) {
			repo.save(m);
			session.setAttribute("message", "successfully added");
			return "redirect:/loadform";
		}
		@PutMapping("/update")
		public String edit(@ModelAttribute LoginModel m, HttpSession session) {
			repo.save(m);
			session.setAttribute("message", "successfully updated");
			return "redirect:/";
		}
		
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable(value = "id") int id ,HttpSession session) {
			repo.deleteById(id);
			session.setAttribute("message", "successfully deleted");
			return "redirect:/";
		}
		
		@GetMapping("/path")
		public String loadform() {
			return "add";
		}
		
	}