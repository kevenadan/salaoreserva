package com.salaoreserva.salaoreserva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salaoreserva.salaoreserva.utils.constants.Routes;

@Controller
@RequestMapping(Routes.Users.ADMIN)
public class AdminController {

	@GetMapping("/home")
	public String clientHome() {
		return "admin/home";
	}
}
