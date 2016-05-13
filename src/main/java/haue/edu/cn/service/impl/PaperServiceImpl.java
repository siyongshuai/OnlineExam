package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.PaperMapper;
import haue.edu.cn.model.Paper;
import haue.edu.cn.service.CommonService;


@Service("paperService")
public class PaperServiceImpl implements CommonService<Paper> {

	
	@Autowired
	private PaperMapper paperDao;
	
	public List<Paper> getQuestionsByPaperId(Integer pid){
		return paperDao.selectQuestionsByPaperId(pid);
	}
	
	
	@Override
	public List<Paper> get() {
		return paperDao.selectAll();
	}

	@Override
	public Paper getOne(Integer id) {
		return paperDao.selectByPrimaryKey(id);
	}

	@Override
	public int add(Paper record) {
		return paperDao.insert(record);
	}

	@Override
	public int delete(Paper record) {
		return paperDao.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int update(Paper record) {
		return paperDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Paper> query(Paper condition) {
		return paperDao.selectAll();
	}

}
