package service;

import entity.FinanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IFiltrateService {
    ArrayList<FinanceEntity> filtrate(String id, String riskLevel) throws SQLException;
}
