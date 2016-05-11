package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.org.eclipse.jdt.internal.compiler.util.Util.Displayable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.QuestionWithBLOBs;
import haue.edu.cn.model.ReturnResult;
import haue.edu.cn.service.impl.QuestionServiceImpl;

@Controller
@RequestMapping("manage_page")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionService;
	
	public AjaxResult ajaxResult = new AjaxResult();
	
	@RequestMapping("/question/get.do")
	@ResponseBody
	public  List<QuestionWithBLOBs> getAll(Model model){
		
		List<QuestionWithBLOBs> questionList = questionService.get();
		
		model.addAttribute("questionList", questionList);
		
		return  questionService.get();
	}
	
	@RequestMapping("/question/display.do")
	public String displayQuestions(Model model){
		List<QuestionWithBLOBs> questionList = questionService.get();
		
		model.addAttribute("questionList", questionList);
		
		return "display";
	}
	
	
	
	@RequestMapping("/question/one.do")
	@ResponseBody
	public QuestionWithBLOBs getOne(Integer id,HttpServletRequest request){
		id = Integer.parseInt(request.getParameter("id"));
		return questionService.getOne(id);
	}
	
	
	
	@RequestMapping("/question/query.do")
	@ResponseBody
	public  List<QuestionWithBLOBs> query(){
		return  questionService.get();
	}
	
	
	
	
	@RequestMapping(value="/question/add.do")
	
	public @ResponseBody ReturnResult add(@RequestBody QuestionWithBLOBs record){
		
		ReturnResult result = new ReturnResult();
	
		try {
			int flag = this.questionService.add(record);;
			if (flag == 1) {
				result.setSuccess("success");
				return result;
			} else {
				result.setError("error");
				return result;
			}
		} catch (Exception e) {
			System.out.println("增加××××××××××试题信息×××××××××发生异常");
			return null;
		}
		
	}
	
	
	@RequestMapping("/question/delete.do")
	public @ResponseBody AjaxResult delete(@RequestBody QuestionWithBLOBs record){
		try {
			questionService.delete(record);
			
		} catch (Exception e) {
			System.out.println("删除××××××××××试题信息×××××××××发生异常");
		}
		return ajaxResult;
	}
	
	@RequestMapping("/question/update.do")
	public @ResponseBody AjaxResult update(@RequestBody QuestionWithBLOBs record){
		try {
			questionService.update(record);
		} catch (Exception e) {
			System.out.println("更新××××××××××试题信息×××××××××发生异常");
		}
		
		return ajaxResult;
	}
	
}
