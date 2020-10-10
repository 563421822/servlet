package service;

import entity.RainEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IShowAllService {
    ArrayList<RainEntity> show() throws SQLException;
}
