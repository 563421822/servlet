package dao;

import entity.PetEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao {
    ArrayList<PetEntity> queryAll() throws SQLException;

    ArrayList<PetEntity> queryByBreed(String breed) throws SQLException;

    int insert(String nickname, String breed, String gender, String birthday, String description) throws SQLException;

}
