package haue.edu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.AdminMapper;
import haue.edu.cn.model.Admin;
import haue.edu.cn.service.CommonService;

@Service("adminLogin")
public class AdminServiceImpl implements CommonService<Admin> {

	@Autowired
	private AdminMapper adminDao;
	
	
	public Admin excuteLogin(Admin adminLogin){
		 return  adminDao.selectByLogin(adminLogin);
	}
	
	
	@Override
	public List<Admin> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Admin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Admin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Admin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Admin> query(Admin condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
