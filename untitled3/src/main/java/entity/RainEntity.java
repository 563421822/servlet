package entity;

import lombok.Data;

import java.sql.Date;

@Data
public class RainEntity {
    private int id;
    private String districtName;
    private Date monitorTime;
    private int rain;
    private String monitoringStation;
    private String monitoringAddress;
}
