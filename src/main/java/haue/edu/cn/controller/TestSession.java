package haue.edu.cn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestSession {

	@RequestMapping("hello.do")
	public String hello(HttpSession session){
		session.setAttribute("message", "hello session ");
		return "welcome";
	}
}
