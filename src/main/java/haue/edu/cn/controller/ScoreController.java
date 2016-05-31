package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.ExamDetail;
import haue.edu.cn.model.ExamInfo;
import haue.edu.cn.model.ScoreCondition;
import haue.edu.cn.service.impl.ExamInfoServiceImpl;
import haue.edu.cn.service.impl.ScoreServiceImpl;

@Controller
@RequestMapping("admin/score")
public class ScoreController implements CommonController<ExamInfo> {

	AjaxResult ajaxResult= new AjaxResult();
	@Autowired
	private ScoreServiceImpl scoreService;
	


	@Autowired
	private ExamInfoServiceImpl eiService;
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<ExamInfo> get() {
		try {
			ScoreCondition scoreCondition = new ScoreCondition();
			return eiService.getUserScore(scoreCondition);
			
		} catch (Exception e) {
			System.out.println("获取用户成绩失败");
			return null;
		}
		
	}

	
	@RequestMapping("getQuestionScore.do")
	@ResponseBody
	public List<ExamDetail> getQuestionScore() {
		// TODO Auto-generated method stub
		return scoreService.computePerQuestionScore();
	}

	@RequestMapping("question.do")
	@ResponseBody
	public AjaxResult updatePerQuestionScore(){
		
		int rows = scoreService.savePerQuestionScore();
		System.out.println("**************************************");
		System.out.println("成功更新了"+rows+"行");
		System.out.println("**************************************");
		return ajaxResult;
	}
	
	@RequestMapping("exam.do")
	@ResponseBody
	public AjaxResult generateUserExamScore(){
		int rows = scoreService.saveUserExamScore();
		System.out.println("**************************************");
		System.out.println("成功更新了"+rows+"行");
		System.out.println("**************************************");
		return ajaxResult;
	}
	
//	先计算每道题的得分，然后更新每道题的得分，接着计算用户考试的总成绩，并批量更新到examinfo表里
	@RequestMapping("generateScore.do")
	public String generateAndSaveScore(){
		try {
			scoreService.savePerQuestionScore();
			scoreService.saveUserExamScore();
			return "successScore";
		} catch (Exception e) {
			return "failScore";
		}
	
}
//学生查看自己的成绩
	@RequestMapping("viewScore.do")
	public String viewScore(){
		return "viewOwnScore";
	}
	
	@RequestMapping("query.do")
	@ResponseBody
	public List<ExamInfo> viewOwnScore(@RequestBody ScoreCondition scoreCondition){
		try {
			return eiService.getUserScore(scoreCondition);
		} catch (Exception e) {
			System.out.println("查询用户成绩失败");
			return null;
		}
	
	}
	
	@Override
	public ExamInfo getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult add(ExamInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult delete(ExamInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult update(ExamInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamInfo> query(ExamInfo condition) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@RequestMapping("manage.do")
	public String manage() {
		return "admin/score";
	}




	
}
