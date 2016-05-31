package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.StudentMapper;
import haue.edu.cn.model.Student;
import haue.edu.cn.service.CommonService;

@Service("studentService")
public class StudentServiceImpl implements CommonService<Student>{

	@Autowired
	private StudentMapper studentDao;
	@Override
	public List<Student> get() {
		// TODO Auto-generated method stub
		return studentDao.selectAll();
	}

	@Override
	public Student getOne(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.selectByPrimaryKey(id);
	}

	@Override
	public int add(Student record) {
		// TODO Auto-generated method stub
		return studentDao.insert(record);
	}

	@Override
	public int delete(Student record) {
		// TODO Auto-generated method stub
		return studentDao.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int update(Student record) {
		// TODO Auto-generated method stub
		return studentDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Student> query(Student condition) {
		// TODO Auto-generated method stub
		return studentDao.selectByCondition(condition);
	}

	/**
	 * 登录
	 * @param student
	 * @return
	 */
	public Student login(Student student) {
		// TODO Auto-generated method stub
		return studentDao.selectByLogin(student);
	}
	public int updatePassword(Student record){
		return studentDao.updateByPrimaryKey(record);
	}
	
}
