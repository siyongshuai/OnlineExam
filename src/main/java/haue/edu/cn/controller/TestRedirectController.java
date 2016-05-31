package haue.edu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("admin/test")
public class TestRedirectController {

	
	@RequestMapping("hello.do")
	public ModelAndView NotInWebINFJsp(){

		return new ModelAndView("/hello");
	}
	@RequestMapping("first.do")
	public ModelAndView fisrtJsp(){

		return new ModelAndView("redirect:second.do");
	}
	@RequestMapping("second.do")
	public ModelAndView secondJsp(){
		String message= "hello spring";
		return new ModelAndView("second","message",message);
	}
}
