package service;

import java.sql.SQLException;

public interface IAddPetService {
    int add(String nickname, String breed, String gender, String birthday, String description) throws SQLException;

}
