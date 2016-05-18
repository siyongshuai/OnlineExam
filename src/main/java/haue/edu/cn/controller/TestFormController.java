package haue.edu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.Student;

@Controller
public class TestFormController {

	@RequestMapping("form/dis.do")
	public ModelAndView getFormJsp(){
		return new ModelAndView("testForm","stu",new Student());
	}
	@RequestMapping("form/res.do")
	public ModelAndView getFormPara(@ModelAttribute("stu2") Student student){
		return new ModelAndView("result");
	}
	
	
}
