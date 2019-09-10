package service;


import utils.ReturnInfo;

public interface BasicService<T> {

	public ReturnInfo select(String where,Integer page, Integer max);
	
	public T selectById(Integer id);
	
	public Integer delete(Integer id);
	
	public Integer insert(T c);
	
	public Integer update(T c);

	
}
