package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.ExamDetail;

public interface CommonController<T> {



	public List<T> get();



	
	public T getOne(HttpServletRequest request);

	
	public AjaxResult add(T record);


	public AjaxResult delete(T record);


	public AjaxResult update(T record);

	
	
	public List<T> query(T condition);


	String manage();

	

	

}
