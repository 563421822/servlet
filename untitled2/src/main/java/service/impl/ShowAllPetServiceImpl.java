package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.PetEntity;
import service.IShowAllPetService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllPetServiceImpl implements IShowAllPetService {
    @Override
    public ArrayList<PetEntity> show() throws SQLException {
        IDao dao = new DaoImpl();
        return dao.queryAll();
    }
}
