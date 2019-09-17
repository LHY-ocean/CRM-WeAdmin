package service;

import java.util.List;

import model.Src;
import utils.ReturnInfo;

public interface SrcService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Src> getAll();

	public Src getById(int id);

	public int delete(int id);

	public Integer insert(Src s);

	public Integer update(Src s);
}
