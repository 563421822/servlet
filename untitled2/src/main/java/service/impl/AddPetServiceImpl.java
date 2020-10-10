package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IAddPetService;

import java.sql.SQLException;

public class AddPetServiceImpl implements IAddPetService {
    @Override
    public int add(String nickname, String breed, String gender, String birthday, String description) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.insert(nickname, breed, gender, birthday, description);
    }
}
