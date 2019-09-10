package service;

import java.util.List;

import model.Position;

public interface PositionService extends BasicService<Position> {

	List<Position> selectAll();
	
}
