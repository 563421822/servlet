package service.impl;

import Dao.IDao;
import Dao.impl.DaoImpl;
import service.IAddProductService;

import java.sql.SQLException;

public class AddProductServiceImpl implements IAddProductService {
    @Override
    public int add(String id, String riskLevel, String prospectiveEarning, String startSale, String endSale, String expire) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.insert(id, riskLevel, prospectiveEarning, startSale, endSale, expire);
    }
}
