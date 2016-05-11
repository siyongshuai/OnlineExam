package haue.edu.cn.model;

import java.sql.Timestamp;

public class Question {
    private Integer id;

    private Integer dbid;

    private Integer qtype;

    private Integer qlevel;

    private Integer qfrom;

    private String status;

    private String optiona;

    private String optionb;

    private String optionc;

    private String optiond;

    private Timestamp postdate;

    private Integer adminid;

    
    public Timestamp getPostdate() {
		return postdate;
	}

	public void setPostdate(Timestamp postdate) {
		this.postdate = postdate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getQtype() {
        return qtype;
    }

    public void setQtype(Integer qtype) {
        this.qtype = qtype;
    }

    public Integer getQlevel() {
        return qlevel;
    }

    public void setQlevel(Integer qlevel) {
        this.qlevel = qlevel;
    }

    public Integer getQfrom() {
        return qfrom;
    }

    public void setQfrom(Integer qfrom) {
        this.qfrom = qfrom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb == null ? null : optionb.trim();
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc == null ? null : optionc.trim();
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond == null ? null : optiond.trim();
    }


    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }
}