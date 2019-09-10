package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PositionDao;
import model.Position;
import service.PositionService;

@Service
public class PositionServiceImpl extends BasicServiceImpl<Position> implements PositionService {
	
	@Autowired
	PositionDao dao;

	public List<Position> selectAll() {
		return dao.select();
	}
	

}
