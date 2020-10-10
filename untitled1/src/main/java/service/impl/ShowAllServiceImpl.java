package service.impl;

import Dao.IDao;
import Dao.impl.DaoImpl;
import entity.FinanceEntity;
import service.IShowALLService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllServiceImpl implements IShowALLService {
    @Override
    public ArrayList<FinanceEntity> queryAll() throws SQLException {
        IDao dao = new DaoImpl();
        return   dao.queryAll();
    }
}
