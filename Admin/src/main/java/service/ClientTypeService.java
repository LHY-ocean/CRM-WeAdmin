package service;

import java.util.List;

import model.ClientType;
import utils.ReturnInfo;

public interface ClientTypeService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<ClientType> getAll();

	public ClientType getById(int id);

	public int delete(int id);

	public Integer insert(ClientType c);

	public Integer update(ClientType c);
}
