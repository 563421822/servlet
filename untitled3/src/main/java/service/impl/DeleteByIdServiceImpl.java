package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IDeleteByIdService;

import java.sql.SQLException;

public class DeleteByIdServiceImpl implements IDeleteByIdService {
    @Override
    public int deleteById(String id) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.deleteById(id);
    }
}
