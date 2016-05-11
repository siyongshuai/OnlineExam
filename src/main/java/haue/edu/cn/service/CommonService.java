package haue.edu.cn.service;

import java.util.List;

public interface CommonService<T> {

	List<T> get();
	T getOne(Integer id);
	int add(T record);
	int delete(T record);
	int update(T record);
	List<T> query(T condition);
}
