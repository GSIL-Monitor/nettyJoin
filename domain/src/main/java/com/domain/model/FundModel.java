package com.domain.model;

/**
 * @author anthony_xu
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/15 13:16 anthony_xu Exp $$
 */
public class FundModel {

    private String fundCode;
    private String fundName;
    private String fundAbbrName;
    private String fundType;
    private String issueDate;
    private String establishDate;
    private String establishScale;
    private String assetValue;
    private String assetValueDate;
    private String units;
    private String unitsDate;
    private String fundManager;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundAbbrName() {
        return fundAbbrName;
    }

    public void setFundAbbrName(String fundAbbrName) {
        this.fundAbbrName = fundAbbrName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getEstablishScale() {
        return establishScale;
    }

    public void setEstablishScale(String establishScale) {
        this.establishScale = establishScale;
    }

    public String getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(String assetValue) {
        this.assetValue = assetValue;
    }

    public String getAssetValueDate() {
        return assetValueDate;
    }

    public void setAssetValueDate(String assetValueDate) {
        this.assetValueDate = assetValueDate;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnitsDate() {
        return unitsDate;
    }

    public void setUnitsDate(String unitsDate) {
        this.unitsDate = unitsDate;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }
}
