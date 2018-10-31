package _06_ResultSetHandler;

public class jdbc01bean {
    private Integer sid;
    private String sname;
    private Double sprice;
    private String sdesc;

    public jdbc01bean() {
    }

    public jdbc01bean(Integer sid, String sname, Double sprice, String sdesc) {
        this.sid = sid;
        this.sname = sname;
        this.sprice = sprice;
        this.sdesc = sdesc;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
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
