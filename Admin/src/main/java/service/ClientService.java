package service;

import java.util.List;

import model.Client;
import utils.ReturnInfo;

public interface ClientService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Client> getAll();

	public Client getById(int id);

	public int delete(int id);

	public Integer insert(Client c);

	public Integer update(Client c);
	
}
