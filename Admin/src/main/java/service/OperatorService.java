package service;

import java.util.List;

import model.Operator;
import utils.ReturnInfo;

public interface OperatorService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Operator> getAll();

	public Operator getById(int id);

	public int delete(int id);

	public Integer insert(Operator o);

	public Integer update(Operator o);

	public Operator selectOperator(Operator o);
}
