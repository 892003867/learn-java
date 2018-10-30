package JDBC04;
public class bean04 {
    private int sid;
    private String sname;
    private Double sprice;
    private String sdesc;

    public bean04() {

    }

    public bean04(int sid, String sname, Double sprice, String sdesc) {
        this.sid = sid;
        this.sname = sname;
        this.sprice = sprice;
        this.sdesc = sdesc;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getSprice() {
        return sprice;
    }

    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }
}
