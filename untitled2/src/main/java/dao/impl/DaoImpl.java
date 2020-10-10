package dao.impl;

import dao.IDao;
import entity.PetEntity;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpl implements IDao {
    @Override
    public ArrayList<PetEntity> queryAll() throws SQLException {
        ArrayList<PetEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM t_pet";
        ResultSet query = DBUtils.query(sql);
        while (query.next()) {
            PetEntity entity = new PetEntity();
            entity.setNickname(query.getString("nickname"));
            entity.setBirthday(query.getString("birthday"));
            entity.setGender(query.getInt("gender"));
            entity.setBreed(query.getInt("breed"));
            entity.setDescription(query.getString("description"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 通过品种查询昵称,生日,性别信息
     *
     * @param breed
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<PetEntity> queryByBreed(String breed) throws SQLException {
        ArrayList<PetEntity> list = new ArrayList<>();
        String sql = "SELECT nickname, birthday, gender FROM t_pet WHERE breed =?";
        ResultSet query = DBUtils.query(sql, breed);
        while (query.next()) {
            PetEntity entity = new PetEntity();
            entity.setNickname(query.getString("nickname"));
            entity.setBirthday(query.getString("birthday"));
            entity.setGender(query.getInt("gender"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public int insert(String nickname, String breed, String gender, String birthday, String description) throws SQLException {
        String sql = "INSERT INTO t_pet ( nickname, birthday, gender, breed, description ) VALUES (?,?,?,?,?)";
        return DBUtils.update(sql, nickname, birthday, gender, breed, description);
    }
}