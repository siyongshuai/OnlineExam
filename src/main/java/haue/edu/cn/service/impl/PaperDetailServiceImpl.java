package haue.edu.cn.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.PaperDetailMapper;
import haue.edu.cn.model.PaperCondition;
import haue.edu.cn.model.PaperDetail;
import haue.edu.cn.model.QuestionID;
import haue.edu.cn.service.CommonService;

@Service("paperDetailService")
public class PaperDetailServiceImpl implements CommonService<PaperDetail> {

	
	@Autowired
	private  PaperDetailMapper paperDetailDao;
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	public List<PaperDetail> getQuestions(Integer pid){
		return paperDetailDao.selectQuestionsByPaperId(pid);
	}
	
	@Override
	public List<PaperDetail> get() {
		return paperDetailDao.selectAll();
	}

	@Override
	public PaperDetail getOne(Integer id) {
		return paperDetailDao.selectByPrimaryKey(id);
	}

	@Override
	public int add(PaperDetail record) {
		return paperDetailDao.insert(record);
	}

	@Override
	public int delete(PaperDetail record) {
		return paperDetailDao.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int update(PaperDetail record) {
		return paperDetailDao.updateByPrimaryKey(record);
	}

	@Override
	public List<PaperDetail> query(PaperDetail condition) {
		return paperDetailDao.selectByCondition(condition);
	}

	/**
	 * 测试批量增加
	 * @param record
	 * @param qtype
	 * @param num
	 * @return
	 */
	public int addBatch(Integer qtype,Integer num) {
		PaperDetail record =new PaperDetail();
		List<QuestionID> questionIDs = questionService.getIdByRandom(qtype, num);
		List<PaperDetail> paperDetails = new ArrayList<PaperDetail>() ;
//		暂定为常量
		int pid =1;
		int cid = 1;
		int score = 2;
		for (Iterator<QuestionID> iterator = questionIDs.iterator(); iterator.hasNext();) {
			record.setPid(iterator.next().getId());
			record.setPid(pid);
			record.setCid(cid);
			record.setScore(score);
			paperDetails.add(record);
		}
		
		return paperDetailDao.insertMore(paperDetails);
	}
	/**
	 * 根据给出的试题类型和试题数量获取问题
	 * @param paperCondition
	 * @return
	 */
	public int addPaperDetailBatch(PaperCondition paperCondition) {
		PaperDetail record =new PaperDetail();
		List<Integer> questionIDs = questionService.getIdsByRandom(paperCondition.getQtype(), paperCondition.getNum());
		List<PaperDetail> paperDetails = new ArrayList<PaperDetail>() ;
//		遍历随机抽取到的questionID
		for (Iterator<Integer> iterator = questionIDs.iterator(); iterator.hasNext();) {
			record.setPid(iterator.next());
			record.setPid(paperCondition.getPid());
			record.setCid(paperCondition.getQtype());
			record.setScore(paperCondition.getPerScore());
//			将paperDeatil对象添加到列表paperDetails
			paperDetails.add(record);
		}
		
		return paperDetailDao.insertMore(paperDetails);
	}
	/**
	 * 获取问题时添加了题库这个选项
	 * @param paperCondition
	 * @return
	 */
	public int addMany(PaperCondition paperCondition) {
		
		List<Integer> questionIDs = questionService.getRandomIds(paperCondition);
		List<PaperDetail> paperDetails = new ArrayList<PaperDetail>() ;
//		遍历随机抽取到的questionID
//		for (Iterator<Integer> iterator = questionIDs.iterator(); iterator.hasNext();) {
//			
//			System.out.println(iterator.next());
//			record.setQid(iterator.next());
//			record.setPid(paperCondition.getPid());
//			record.setCid(paperCondition.getQtype());
//			record.setScore(paperCondition.getPerScore());
////			将paperDeatil对象添加到列表paperDetails
//			paperDetails.add(record);
//		}
		
		for (int index = 0; index < questionIDs.size();index++){
			PaperDetail record =new PaperDetail();
			record.setQid(questionIDs.get(index));
			record.setPid(paperCondition.getPid());
			record.setCid(paperCondition.getQtype());
			record.setScore(paperCondition.getPerScore());
//			将paperDeatil对象添加到列表paperDetails
			paperDetails.add(record);
		}

		
		
		return paperDetailDao.insertMore(paperDetails);
	}
	
	
	
}
