package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.PaperCondition;
import haue.edu.cn.model.QuestionCondition;
import haue.edu.cn.model.QuestionID;
import haue.edu.cn.model.QuestionWithBLOBs;
import haue.edu.cn.model.ReturnResult;
import haue.edu.cn.service.impl.QuestionServiceImpl;

@Controller
@RequestMapping("admin/question")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionService;
	
	public AjaxResult ajaxResult = new AjaxResult();
	
	@RequestMapping("manage.do")
	public String manage(){
		return "admin/question";
	};
	
	
	@RequestMapping("get.do")
	@ResponseBody
	public  List<QuestionWithBLOBs> getAll(Model model){
		try {
			List<QuestionWithBLOBs> questionList = questionService.get();
			
			model.addAttribute("questionList", questionList);
			
			return  questionService.get();
		} catch (Exception e) {
			System.out.println("获取问题失败");
			return null;
		}
		
	}
	
	@RequestMapping("random.do")
	@ResponseBody
	public  List<QuestionID> getIds(HttpServletRequest request){
		
	int qtype =1;
	int num =10;
		
		return  questionService.getIdByRandom(qtype, num);
	}
	
	@RequestMapping("random2.do")
	@ResponseBody
	public  List<Integer> getIdsByRandom(HttpServletRequest request){
		
	int qtype =1;
	int num =10;
		
		return  questionService.getIdsByRandom(qtype, num);
	}
	
	@RequestMapping("random3.do")
	@ResponseBody
	public  List<Integer> getRandomIdsByCondition(HttpServletRequest request){
		
		QuestionCondition questionCondition = new QuestionCondition();

		questionCondition.setDbid(1);
		questionCondition.setNum(10);
		questionCondition.setQtype(1);
		return  questionService.getRandomIdsByCondition(questionCondition);
	}
	@RequestMapping("random4.do")
	@ResponseBody
	public  List<Integer> getRandomIds(HttpServletRequest request){
		
		PaperCondition paperCondition = new PaperCondition();

		paperCondition.setQuestiondb(1);
		paperCondition.setNum(10);
		paperCondition.setQtype(1);
		return  questionService.getRandomIds(paperCondition);
	}
	
	@RequestMapping("display.do")
	public String displayQuestions(Model model){
		List<QuestionWithBLOBs> questionList = questionService.get();
		
		model.addAttribute("questionList", questionList);
		
		return "display";
	}
	
	
	
	@RequestMapping("one.do")
	@ResponseBody
	public QuestionWithBLOBs getOne(Integer id,HttpServletRequest request){
		id = Integer.parseInt(request.getParameter("id"));
		return questionService.getOne(id);
	}
	
	
	
	@RequestMapping("query.do")
	@ResponseBody
	public  List<QuestionWithBLOBs> query(){
		return  questionService.get();
	}
	
	
	
	
	@RequestMapping(value="add.do")
	
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
	
	
	@RequestMapping("delete.do")
	public @ResponseBody AjaxResult delete(@RequestBody QuestionWithBLOBs record){
		try {
			questionService.delete(record);
			
		} catch (Exception e) {
			System.out.println("删除××××××××××试题信息×××××××××发生异常");
		}
		return ajaxResult;
	}
	
	@RequestMapping("update.do")
	public @ResponseBody AjaxResult update(@RequestBody QuestionWithBLOBs record){
		try {
			questionService.update(record);
		} catch (Exception e) {
			System.out.println("更新××××××××××试题信息×××××××××发生异常");
		}
		
		return ajaxResult;
	}
	
}
