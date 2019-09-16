package service;

import java.util.List;

import model.WorkGroup;
import utils.ReturnInfo;

public interface WorkGroupService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<WorkGroup> getAll();

	public WorkGroup getById(int id);

	public int delete(int id);

	public Integer insert(WorkGroup w);

	public Integer update(WorkGroup w);

}
