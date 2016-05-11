package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.QuestionDBMapper;
import haue.edu.cn.model.QuestionDB;

@Service("questionDBService")
public class QuestionDBServiceImpl {

	@Autowired
	private QuestionDBMapper questionDBDao;
	
	public  List<QuestionDB> getAll(){
		return questionDBDao.selectAll();
	}
	
	
	
}
