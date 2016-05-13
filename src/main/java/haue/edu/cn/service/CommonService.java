package haue.edu.cn.service;

import java.util.List;

public interface CommonService<T> {

	public List<T> get();

	public T getOne(Integer id);

	public int add(T record);

	public int delete(T record);

	public int update(T record);

	public List<T> query(T condition);
}
