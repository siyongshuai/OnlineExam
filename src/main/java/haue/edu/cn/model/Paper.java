package haue.edu.cn.model;

import java.util.Date;

public class Paper {
    private Integer id;

    private String paperName;

    private Integer adminid;

    private String status;

    private String starttime;

    private String endtime;

    private Integer paperMinute;

    private Integer totalScore;

    private String remark;

    private String qorder;

    private Date postdate;

    private String showScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getPaperMinute() {
        return paperMinute;
    }

    public void setPaperMinute(Integer paperMinute) {
        this.paperMinute = paperMinute;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getQorder() {
        return qorder;
    }

    public void setQorder(String qorder) {
        this.qorder = qorder == null ? null : qorder.trim();
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getShowScore() {
        return showScore;
    }

    public void setShowScore(String showScore) {
        this.showScore = showScore == null ? null : showScore.trim();
    }
}