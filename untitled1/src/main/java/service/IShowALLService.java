package service;

import entity.FinanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IShowALLService {
    ArrayList<FinanceEntity> queryAll() throws SQLException;
}
