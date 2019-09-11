package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LevelDao;
import dao.PositionDao;
import model.Level;
import model.Position;
import service.LevelService;
import service.PositionService;

@Service
public class LevelServiceImpl extends BasicServiceImpl<Level> implements LevelService {
	
	@Autowired
	LevelDao dao;

	public List<Level> getAll() {
		return dao.getAll();
	}
	

}
