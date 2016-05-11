package haue.edu.cn.model;

import java.sql.Timestamp;

public class QuestionDB {
    private Integer id;

    private String dname;

    private String remark;

    private Integer adminid;

    private Timestamp cdate;

    private String status;

    
    
    public Timestamp getCdate() {
		return cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}