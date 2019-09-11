package service;

import java.util.List;

import model.Level;

public interface LevelService extends BasicService<Level> {

	List<Level> getAll();
	
}
