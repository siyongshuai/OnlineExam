package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.ExamInfoMapper;
import haue.edu.cn.model.ExamInfo;
import haue.edu.cn.model.ScoreCondition;
import haue.edu.cn.service.CommonService;

@Service("eiService")
public class ExamInfoServiceImpl implements CommonService<ExamInfo> {

	@Autowired
	private ExamInfoMapper eiDao;
	
	public int updateMany(List<ExamInfo> examInfos){
		return eiDao.updateMore(examInfos);
	}
	
	public List<ExamInfo> getUserScore(ScoreCondition scoreCondition){
		
		return eiDao.selectUserScore(scoreCondition);
	}
	
	@Override
	public List<ExamInfo> get() {
		// TODO Auto-generated method stub
		return eiDao.selectAll();
	}

	@Override
	public ExamInfo getOne(Integer id) {
		// TODO Auto-generated method stub
		return eiDao.selectByPrimaryKey(id);
	}

	@Override
	public int add(ExamInfo record) {
		// TODO Auto-generated method stub
		return eiDao.insert(record);
	}

	@Override
	public int delete(ExamInfo record) {
		// TODO Auto-generated method stub
		return eiDao.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int update(ExamInfo record) {
		// TODO Auto-generated method stub
		return eiDao.updateByPrimaryKey(record);
	}

	@Override
	public List<ExamInfo> query(ExamInfo condition) {
		// TODO Auto-generated method stub
		return eiDao.selectByCondition(condition);
	}

}
