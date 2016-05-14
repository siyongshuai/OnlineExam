package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.ExamDetail;
import haue.edu.cn.service.impl.ExamDetailServiceImpl;
import haue.edu.cn.service.impl.ScoreServiceImpl;

@Controller
@RequestMapping("manage_page/score")
public class ScoreController implements CommonController<ExamDetail> {

	AjaxResult ajaxResult= new AjaxResult();
	@Autowired
	private ScoreServiceImpl scoreService;
	
	@Autowired
	private ExamDetailServiceImpl edService;
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<ExamDetail> get() {
		// TODO Auto-generated method stub
		return scoreService.computeScore();
	}

	@RequestMapping("many.do")
	@ResponseBody
	public AjaxResult updateMany(){
		List<ExamDetail> examDetails = scoreService.computeScore();
		int rows = edService.updateMany(examDetails);
		System.out.println("**************************************");
		System.out.println("成功更新了"+rows+"行");
		System.out.println("**************************************");
		return ajaxResult;
	}
	
	
	@Override
	public ExamDetail getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult add(ExamDetail record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult delete(ExamDetail record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult update(ExamDetail record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamDetail> query(ExamDetail condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
