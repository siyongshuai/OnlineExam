package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.Paper;
import haue.edu.cn.service.impl.PaperServiceImpl;

@Controller
@RequestMapping("manage_page/paper")
public class PaperController implements CommonController<Paper> {

	@Autowired
	private PaperServiceImpl paperService;
	
	@RequestMapping("jsp.do")
	public String paper(){
		return "paper";
	}
	
	
	public AjaxResult ajaxResult = new AjaxResult();
	
	@RequestMapping("only.do")
	@ResponseBody
	public List<Paper> getQuestionsByPaperId(HttpServletRequest request) {
		 int id = Integer.parseInt(request.getParameter("id"));
		return paperService.getQuestionsByPaperId(id);
	}
	
	@RequestMapping("display.do")
	public String displayQuestion(HttpServletRequest request,HttpServletResponse response,Model model){
		 int pid = Integer.parseInt(request.getParameter("id"));
		List<Paper> paperQuestionList = paperService.getQuestionsByPaperId(pid);
		model.addAttribute("questionList", paperQuestionList);
		return "display";
	}
	
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<Paper> get() {
		return paperService.get();
	}

	@Override
	@RequestMapping("one.do")
	public Paper getOne(HttpServletRequest request) {
		 int id = Integer.parseInt(request.getParameter("id"));
		return paperService.getOne(id);
	}

	@Override
	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult add(@RequestBody Paper record) {
		 paperService.add(record);
		 return ajaxResult;
	}

	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(@RequestBody Paper record) {
 	paperService.delete(record);
		return ajaxResult;
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(@RequestBody Paper record) {
		paperService.update(record);
		
		return ajaxResult;
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<Paper> query(@RequestBody Paper condition) {
		
		return paperService.get();
	}

	

}
