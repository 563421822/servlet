package Dao;

import entity.FinanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao {
    ArrayList<FinanceEntity> queryAll() throws SQLException;

    ArrayList<FinanceEntity> queryBy(String id, String riskLevel) throws SQLException;

    int insert(String id, String riskLevel, String prospectiveEarning, String startSale, String endSale, String expire) throws SQLException;

}
