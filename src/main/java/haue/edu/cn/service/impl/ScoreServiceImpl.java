package haue.edu.cn.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.ExamDetailMapper;
import haue.edu.cn.dao.ExamInfoMapper;
import haue.edu.cn.model.ExamDetail;
import haue.edu.cn.model.ExamInfo;

@Service("scoreService")
public class ScoreServiceImpl{

	@Autowired
	private ExamDetailMapper edDao;
	
	@Autowired
	private ExamInfoMapper eiDao;
	
	public List<ExamDetail> computePerQuestionScore(){
//		先取出用户提交的答案
		List<ExamDetail> examDetails = edDao.selectUserAnswer();
		for (Iterator<ExamDetail> iterator = examDetails.iterator(); iterator.hasNext();) {
			ExamDetail examDetail = (ExamDetail) iterator.next();
//			判断用户答案和标准答案是否一致，如果一致根据试卷设置正确的分数
			if (examDetail.getUserAnswer().equals(examDetail.getQuestion().getSkey())) {
				System.out.println("用户试卷id"+examDetail.getPid());
				System.out.println("用户试卷答案"+examDetail.getUserAnswer());
				examDetail.setScore(examDetail.getPaperDetail().getScore());
				System.out.println("答案正确计算后的结果"+examDetail.getScore());
			}
			else{
				examDetail.setScore(0);
				System.out.println("答案错误计算后的结果"+examDetail.getScore());
			}
		}
		return examDetails;
	}
	
//	保存计算后每题的成绩
	public int savePerQuestionScore(){
		return edDao.updateMore(computePerQuestionScore());
	}
//保存计算后用户的考卷成绩
	public int saveUserExamScore(){
		List<ExamInfo> examInfos = edDao.selectUserExamScore();
		return eiDao.updateMore(examInfos);
	}
	
	
	
}
