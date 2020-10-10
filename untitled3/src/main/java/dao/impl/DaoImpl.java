package dao.impl;

import dao.IDao;
import entity.RainEntity;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpl implements IDao {
    @Override
    public ArrayList<RainEntity> queryAll() throws SQLException {
        String sql = "SELECT id, district_name, monitor_time, rain, monitoring_station, monitoring_address FROM t_rain_quality";
        ArrayList<RainEntity> list = new ArrayList<>();
        ResultSet query = DBUtils.query(sql);
        while (query.next()) {
            RainEntity entity = new RainEntity();
            entity.setId(query.getInt("id"));
            entity.setDistrictName(query.getString("district_name"));
            entity.setMonitorTime(query.getDate("monitor_time"));
            entity.setRain(query.getInt("rain"));
            entity.setMonitoringStation(query.getString("monitoring_station"));
            entity.setMonitoringAddress(query.getString("monitoring_address"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public int deleteById(String id) throws SQLException {
        String sql = "DELETE FROM t_rain_quality WHERE id =?";
        return DBUtils.update(sql, id);
    }

    @Override
    public int insert(String districtName, String monitorTime, String rain, String monitoringStation, String monitoringAddress) throws SQLException {
        String sql = "INSERT INTO t_rain_quality ( district_name, monitor_time, rain, monitoring_station, monitoring_address ) VALUES (?,?,?,?,?)";
        return DBUtils.update(sql, districtName, monitorTime, rain, monitoringStation, monitoringAddress);
    }
}

