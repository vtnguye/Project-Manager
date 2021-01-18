package vn.molu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	@RequestMapping({ "/sample/", "/sample/index.html" })
	public String index() {
		return "index";
	}

	@RequestMapping("sample/login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("sample/register")
	public String register() {
		System.out.println("=====================");
		return "register";
	}
}
