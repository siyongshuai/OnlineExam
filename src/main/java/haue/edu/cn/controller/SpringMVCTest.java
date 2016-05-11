package haue.edu.cn.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("manage_page")
public class SpringMVCTest {

	@RequestMapping("jump.do")
	public String testview(){
		return "hello";
	}
	
	@RequestMapping("mav.do")
	public ModelAndView testModelAndView( ){
//		jsp name
		
		ModelAndView mav = new ModelAndView("mav");
//		mav.setViewName("mav");
        String name = "siyongshuai";
        Integer sex= 1;
     mav.addObject("name",name);
     mav.addObject("sex", sex);
		
		return  mav;
		
	}
	
	@RequestMapping("model.do")
	public String testModel(Model model){
        String name = "siyongshuai";
        Integer sex= 1;
        model.addAttribute("name", name);
        model.addAttribute("sex", sex);
		return "model";
	}
	
	
}
