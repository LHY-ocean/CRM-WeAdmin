package service;

import java.util.List;

import model.Revisit;
import utils.ReturnInfo;

public interface RevisitService {

	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Revisit> getAll();

	public Revisit getById(int id);

	public int delete(int id);

	public Integer insert(Revisit r);

	public Integer update(Revisit r);
}
