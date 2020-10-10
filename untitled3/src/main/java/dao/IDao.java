package dao;

import entity.RainEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao {
    ArrayList<RainEntity> queryAll() throws SQLException;

    int deleteById(String id) throws SQLException;

    int insert(String districtName, String monitorTime, String rain, String monitoringStation, String monitoringAddress) throws SQLException;

}
