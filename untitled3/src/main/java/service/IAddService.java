package service;

import java.sql.SQLException;

public interface IAddService {
    int add(String districtName, String monitorTime, String rain, String monitoringStation, String monitoringAddress) throws SQLException;
}
