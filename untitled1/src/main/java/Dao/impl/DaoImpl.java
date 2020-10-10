package Dao.impl;

import Dao.IDao;
import entity.FinanceEntity;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpl implements IDao {
    /**
     * 查询所有信息的方法
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<FinanceEntity> queryAll() throws SQLException {
        String sql = "SELECT * FROM t_finance";
        ArrayList<FinanceEntity> list = new ArrayList<>();
        ResultSet query = DBUtils.query(sql);
        while (query.next()) {
            FinanceEntity entity = new FinanceEntity();
            entity.setId(query.getString("id"));
            entity.setRiskLevel(query.getString("risk_level"));
            entity.setProspectiveEarning(query.getString("prospective_earning"));
            entity.setStartSale(query.getString("start_sale"));
            entity.setEndSale(query.getString("end_sale"));
            entity.setExpire(query.getString("expire"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 通过id和风险等级查询信息
     *
     * @param id
     * @param riskLevel
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<FinanceEntity> queryBy(String id, String riskLevel) throws SQLException {
        String sql = "SELECT * FROM t_finance WHERE id =? AND risk_level =?";
        ArrayList<FinanceEntity> list = new ArrayList<>();
        ResultSet query = DBUtils.query(sql, id, riskLevel);
        while (query.next()) {
            FinanceEntity entity = new FinanceEntity();
            entity.setId(query.getString("id"));
            entity.setRiskLevel(query.getString("risk_level"));
            entity.setProspectiveEarning(query.getString("prospective_earning"));
            entity.setStartSale(query.getString("start_sale"));
            entity.setEndSale(query.getString("end_sale"));
            entity.setExpire(query.getString("expire"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 插入的方法
     *
     * @param id
     * @param riskLevel
     * @param prospectiveEarning
     * @param startSale
     * @param endSale
     * @param expire
     * @return
     */
    @Override
    public int insert(String id, String riskLevel, String prospectiveEarning, String startSale, String endSale, String expire) throws SQLException {
        String sql = "INSERT INTO t_finance ( id, risk_level, prospective_earning, start_sale, end_sale, expire ) VALUE (?,?,?,?,?,?)";
        return DBUtils.update(sql, id, riskLevel, prospectiveEarning, startSale, endSale, expire);
    }
}