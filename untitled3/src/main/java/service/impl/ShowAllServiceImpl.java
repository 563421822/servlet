package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.RainEntity;
import service.IShowAllService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllServiceImpl implements IShowAllService {
    @Override
    public ArrayList<RainEntity> show() throws SQLException {
        IDao dao = new DaoImpl();
        return dao.queryAll();
    }
}
