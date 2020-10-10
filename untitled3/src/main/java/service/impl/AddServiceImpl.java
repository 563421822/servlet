package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IAddService;

import java.sql.SQLException;

public class AddServiceImpl implements IAddService {
    @Override
    public int add(String districtName, String monitorTime, String rain, String monitoringStation, String monitoringAddress) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.insert(districtName, monitorTime, rain, monitoringStation, monitoringAddress);
    }
}
