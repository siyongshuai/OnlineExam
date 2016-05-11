package haue.edu.cn.model;

import java.sql.Timestamp;

public class ExamInfo {
    private Integer id;

    private Integer uid;

    private Integer pid;

    private Timestamp sdate;

    private Timestamp edate;

    private String ip;

    private Integer score;

    private String status;

    private String remark;
    

    public Timestamp getSdate() {
		return sdate;
	}

	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}

	public Timestamp getEdate() {
		return edate;
	}

	public void setEdate(Timestamp edate) {
		this.edate = edate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}