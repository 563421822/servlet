package service;

import entity.PetEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IShowAllPetService {
    ArrayList<PetEntity> show() throws SQLException;
}
