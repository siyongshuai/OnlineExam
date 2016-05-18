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
import haue.edu.cn.service.impl.ExamDetailServiceImpl;
import haue.edu.cn.service.impl.ExamInfoServiceImpl;

@Controller
@RequestMapping("manage_page/ed")
public class ExamDetailController implements CommonController<ExamDetail> {

	AjaxResult ajaxResult = new AjaxResult();
	@Autowired
	private ExamDetailServiceImpl edService;
	
	@Autowired
	private ExamInfoServiceImpl   eiService;
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<ExamDetail> get() {
		// TODO Auto-generated method stub
		return edService.getUserAnswers();
	}
	@RequestMapping("get2.do")
	@ResponseBody
	public List<ExamInfo> get2() {
		// TODO Auto-generated method stub
		return edService.getUserExamScore();
	}
	@Override
	@RequestMapping("one.do")
	@ResponseBody
	public ExamDetail getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		return edService.getOne(id);
	}

	@Override
	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult add(@RequestBody ExamDetail record) {
		// TODO Auto-generated method stub
		if(edService.add(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
		
	}
	/**
	 * 将用户答案存储到examdetail表中,同时将pid,uid信息存储到examInfo中
	 * @param examDetails
	 * @return
	 */
	@RequestMapping("many.do")
	@ResponseBody
	public AjaxResult addMany(@RequestBody List<ExamDetail> examDetails) {
		// TODO Auto-generated method stub
		try {
			if(edService.addMany(examDetails)>0){
				int uid = examDetails.get(0).getUid();
				int pid = examDetails.get(0).getPid();
				ExamInfo examInfo = new ExamInfo();
				examInfo.setUid(uid);
				examInfo.setPid(pid);
				eiService.add(examInfo);//将pid 和uid信息加入到examinfo里面
				return  ajaxResult;
			}else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("批量增加发生异常");
			return null;
			
		}
		
		
	}
	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(@RequestBody ExamDetail record) {
		// TODO Auto-generated method stub
		if(edService.delete(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(@RequestBody ExamDetail record) {
		if(edService.update(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<ExamDetail> query(@RequestBody ExamDetail condition) {
	
	return edService.query(condition);
	}

}
