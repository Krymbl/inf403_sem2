package Unknown;

public class RawRow {
    // 6
    private String riskScoreCVRM;
    // 7
    private String mdrd;
    // 9
    private String glucoseFasting;
    // 11
    private String totalCholesterol;
    // 13
    private String systolicBloodPressure;
    // 14
    private String diastolicBloodPressure;
    // 16
    private String bmi;
    // 18
    private String psCVRM;
    // 19
    private String smokingStatus;
    // 22
    private String age;
    // 23
    private String hypertension;

    public boolean badRecord() {
        return true;
    }

    public String getRiskScoreCVRM() {
        return riskScoreCVRM;
    }

    public void setRiskScoreCVRM(String riskScoreCVRM) {
        this.riskScoreCVRM = riskScoreCVRM;
    }

    public String getMdrd() {
        return mdrd;
    }

    public void setMdrd(String mdrd) {
        this.mdrd = mdrd;
    }

    public String getGlucoseFasting() {
        return glucoseFasting;
    }

    public void setGlucoseFasting(String glucoseFasting) {
        this.glucoseFasting = glucoseFasting;
    }

    public String getTotalCholesterol() {
        return totalCholesterol;
    }

    public void setTotalCholesterol(String totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    public String getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(String systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public String getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(String diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getPsCVRM() {
        return psCVRM;
    }

    public void setPsCVRM(String psCVRM) {
        this.psCVRM = psCVRM;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }
}