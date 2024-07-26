package com.cloth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.cloth.Repository.UserRepository;
import com.cloth.Repository.WorkerRepository;
import com.cloth.model.User;
import com.cloth.model.Worker;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping("/")
	public String showDashboard() {
		return "Dashboard_login.html";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model) {
		String username = "user@example.com"; // Explicit username
		String password = "pass123"; // Explicit password

		User user = userRepository.findByEmail(username);

		if (user != null && user.getPassword().equals(password)) {
			return "Dashboard.html";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	// worker Login

	@GetMapping("/workerlogin")
	public String WorkerloginForm() {
		return "workerlogin";
	}

	@PostMapping("/workerlogin")
	public String workerlogin(Model model) {
		String username = "employee@example.com"; // Explicit username
		String password = "pass1234"; // Explicit password

		Worker worker = workerRepository.findByEmail(username);

		if (worker != null && worker.getPassword().equals(password)) {
			return "Dashboard.html";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "workerlogin";
		}
	}

}
