package entity;

import lombok.Data;

@Data
public class FinanceEntity {
    private String id;
    private String riskLevel;
    private String prospectiveEarning;
    private String startSale;
    private String endSale;
    private String expire;
}
