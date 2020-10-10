package service;

import java.sql.SQLException;

public interface IAddProductService {
    int add(String id, String riskLevel, String prospectiveEarning, String startSale, String endSale, String expire) throws SQLException;
}
