package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.PetEntity;
import service.IByBreedService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ByBreedServiceImpl implements IByBreedService {
    @Override
    public ArrayList<PetEntity> queryByBreed(String breed) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.queryByBreed(breed);
    }
}
