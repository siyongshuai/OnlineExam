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
	
	public int add(QuestionDB record){
		return questionDBDao.insert(record);
	}
	
	public int delete(QuestionDB record){
		return questionDBDao.deleteByPrimaryKey(record.getId());
	}
	
	public int update(QuestionDB record){
		return questionDBDao.updateByPrimaryKey(record);
	}
	
	public List<QuestionDB> query(QuestionDB condition){
		return questionDBDao.selectByCondition(condition);
	}
}
