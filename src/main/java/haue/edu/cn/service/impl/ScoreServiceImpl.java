package haue.edu.cn.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.ExamDetailMapper;
import haue.edu.cn.model.ExamDetail;

@Service("scoreService")
public class ScoreServiceImpl{

	@Autowired
	private ExamDetailMapper edDao;
	
	public List<ExamDetail> computeScore(){
		List<ExamDetail> examDetails = edDao.selectUserAnswer();
		for (Iterator<ExamDetail> iterator = examDetails.iterator(); iterator.hasNext();) {
			ExamDetail examDetail = (ExamDetail) iterator.next();
//			判断用户答案和标准答案是否一致
			if (examDetail.getUserAnswer().equals(examDetail.getQuestion().getSkey())) {
				examDetail.setScore(examDetail.getPaperDetail().getScore());
			}
			else{
				examDetail.setScore(0);
			}
		}
		return examDetails;
	}
}
