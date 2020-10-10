package service;

import entity.PetEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IByBreedService {
    ArrayList<PetEntity> queryByBreed(String breed) throws SQLException;
}
