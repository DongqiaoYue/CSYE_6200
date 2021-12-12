package neu.edu.csye6200;

public class VaccRecord {

    private int studentId;

    private int Hib;

    private int DTaP;

    private int Polio;

    private int HepatitsB;

    private int MMR;

    private int Varicella;

    private String HibLastUpdateDate;

    private String DTapLastUpdateDate;

    private String PoliLastUpdateDate;

    private String HepatitsBLastUpdateDate;

    private String MMRLastUpdateDate;

    private String VaricellaLastUpdateDate;

    public int getHib() {
        return Hib;
    }

    public void setHib(int hib) {
        Hib = hib;
    }

    public int getDTaP() {
        return DTaP;
    }

    public void setDTaP(int dTaP) {
        DTaP = dTaP;
    }

    public int getPolio() {
        return Polio;
    }

    public void setPolio(int polio) {
        Polio = polio;
    }

    public int getHepatitsB() {
        return HepatitsB;
    }

    public void setHepatitsB(int hepatitsB) {
        HepatitsB = hepatitsB;
    }

    public int getMMR() {
        return MMR;
    }

    public void setMMR(int mMR) {
        MMR = mMR;
    }

    public int getVaricella() {
        return Varicella;
    }

    public void setVaricella(int varicella) {
        Varicella = varicella;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getHibLastUpdateDate() {
        return HibLastUpdateDate;
    }

    public void setHibLastUpdateDate(String hibLastUpdateDate) {
        HibLastUpdateDate = hibLastUpdateDate;
    }

    public String getDTapLastUpdateDate() {
        return DTapLastUpdateDate;
    }

    public void setDTapLastUpdateDate(String DTapLastUpdateDate) {
        this.DTapLastUpdateDate = DTapLastUpdateDate;
    }

    public String getPoliLastUpdateDate() {
        return PoliLastUpdateDate;
    }

    public void setPoliLastUpdateDate(String poliLastUpdateDate) {
        PoliLastUpdateDate = poliLastUpdateDate;
    }

    public String getHepatitsBLastUpdateDate() {
        return HepatitsBLastUpdateDate;
    }

    public void setHepatitsBLastUpdateDate(String hepatitsBLastUpdateDate) {
        HepatitsBLastUpdateDate = hepatitsBLastUpdateDate;
    }

    public String getMMRLastUpdateDate() {
        return MMRLastUpdateDate;
    }

    public void setMMRLastUpdateDate(String MMRLastUpdateDate) {
        this.MMRLastUpdateDate = MMRLastUpdateDate;
    }

    public String getVaricellaLastUpdateDate() {
        return VaricellaLastUpdateDate;
    }

    public void setVaricellaLastUpdateDate(String varicellaLastUpdateDate) {
        VaricellaLastUpdateDate = varicellaLastUpdateDate;
    }

    public static VaccRecord parseVaccRecord(String CSV){
        String[] strs = CSV.split(",");
        VaccRecord vaccRecord = new VaccRecord();
        vaccRecord.setStudentId(Integer.valueOf(strs[0]));
        vaccRecord.setHib(Integer.valueOf(strs[1]));
        vaccRecord.setDTaP(Integer.valueOf(strs[2]));
        vaccRecord.setPolio(Integer.valueOf(strs[3]));
        vaccRecord.setHepatitsB(Integer.valueOf(strs[4]));
        vaccRecord.setMMR(Integer.valueOf(strs[5]));
        vaccRecord.setVaricella(Integer.valueOf(strs[6]));
        vaccRecord.setHibLastUpdateDate(strs[7]);
        vaccRecord.setDTapLastUpdateDate(strs[8]);
        vaccRecord.setPoliLastUpdateDate(strs[9]);
        vaccRecord.setHepatitsBLastUpdateDate(strs[10]);
        vaccRecord.setMMRLastUpdateDate(strs[11]);
        vaccRecord.setVaricellaLastUpdateDate(strs[12]);
        return vaccRecord;
    }

    public String toString(){
        return getStudentId() + "," +
                getHib() + "," +
                getDTaP() + "," +
                getPolio() + "," +
                getHepatitsB() + "," +
                getMMR() + "," +
                getVaricella() + "," +
                getHibLastUpdateDate() + "," +
                getDTapLastUpdateDate() + "," +
                getPoliLastUpdateDate() + "," +
                getHepatitsBLastUpdateDate() + "," +
                getMMRLastUpdateDate() + "," +
                getVaricellaLastUpdateDate();
    }

    public static void main(String[] args) {
        //test


    }
}
