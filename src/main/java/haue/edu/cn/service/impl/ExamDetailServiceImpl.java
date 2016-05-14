package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.ExamDetailMapper;
import haue.edu.cn.model.ExamDetail;
import haue.edu.cn.service.CommonService;

@Service("edService")
public class ExamDetailServiceImpl implements CommonService<ExamDetail> {

	@Autowired
	private ExamDetailMapper edDao;
	
	public int addMany(List<ExamDetail> examDetails){
		return edDao.insertMore(examDetails);
	}
	
	public int updateMany(List<ExamDetail> examDetails){
		return edDao.updateMore(examDetails);
	}
	
	public List<ExamDetail> getUserAnswers(){
		return edDao.selectUserAnswer();
	}
	
	
	@Override
	public List<ExamDetail> get() {
		// TODO Auto-generated method stub
		return edDao.selectAll();
	}

	@Override
	public ExamDetail getOne(Integer id) {
		// TODO Auto-generated method stub
		return edDao.selectByPrimaryKey(id);
	}

	@Override
	public int add(ExamDetail record) {
		// TODO Auto-generated method stub
		return edDao.insert(record);
	}

	@Override
	public int delete(ExamDetail record) {
		// TODO Auto-generated method stub
		return edDao.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int update(ExamDetail record) {
		// TODO Auto-generated method stub
		return update(record);
	}

	@Override
	public List<ExamDetail> query(ExamDetail condition) {
		// TODO Auto-generated method stub
		return edDao.selectByCondition(condition);
	}

}
