package service.impl;

import Dao.IDao;
import Dao.impl.DaoImpl;
import entity.FinanceEntity;
import service.IFiltrateService;

import java.sql.SQLException;
import java.util.ArrayList;

public class FiltrateServiceImpl implements IFiltrateService {
    @Override
    public ArrayList<FinanceEntity> filtrate(String id, String riskLevel) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.queryBy(id,riskLevel);
    }
}
