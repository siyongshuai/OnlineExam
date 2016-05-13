package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.QuestionMapper;
import haue.edu.cn.model.PaperCondition;
import haue.edu.cn.model.QuestionCondition;
import haue.edu.cn.model.QuestionID;
import haue.edu.cn.model.QuestionWithBLOBs;
import haue.edu.cn.service.CommonService;



@Service("questionService")
public class QuestionServiceImpl implements CommonService<QuestionWithBLOBs> {

	@Autowired
	private QuestionMapper questionDao;
	
	public List<QuestionWithBLOBs> get(){
	 return questionDao.selectAll();
		
	}
 	
	public List<QuestionID> getIdByRandom(Integer qtype,Integer num){
		return questionDao.selectIdByRandom(qtype, num);
	}
	
	public List<Integer> getIdsByRandom(Integer qtype,Integer num){
		return questionDao.selectIdsByRandom(qtype, num);
	}
	
	public List<Integer> getRandomIdsByCondition(QuestionCondition questionCondition){
		return questionDao.selectRandomIdsByCondition(questionCondition);
	}
	
	public List<Integer> getRandomIds(PaperCondition paperCondition){
		return questionDao.selectRandomIds(paperCondition);
	}
	
	public int add(QuestionWithBLOBs record){
		 return questionDao.insert(record);
	}
	public int delete(QuestionWithBLOBs record){
		 return questionDao.deleteByPrimaryKey(record.getId());
	}
	public int update(QuestionWithBLOBs record){
		 return questionDao.updateByPrimaryKeyWithBLOBs(record);
	}

	public List<QuestionWithBLOBs> query(QuestionWithBLOBs condition) {
		
		return null;
	}


	@Override
	public QuestionWithBLOBs getOne(Integer id) {
		
		return questionDao.selectByPrimaryKey(id);
	}


}
