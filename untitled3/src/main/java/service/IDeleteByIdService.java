package service;

import java.sql.SQLException;

public interface IDeleteByIdService {
    int deleteById(String id) throws SQLException;
}
