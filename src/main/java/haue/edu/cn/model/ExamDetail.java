package haue.edu.cn.model;

public class ExamDetail {
    private Integer id;

    private Integer uid;

    private Integer pid;

    private Integer qid;

    private String userAnswer;

    private String status;

    private Integer score;

    private String remark;

    private Integer qtype;
    
    private PaperDetail paperDetail;
    
    private QuestionWithBLOBs question;
    
    



	public QuestionWithBLOBs getQuestion() {
		return question;
	}

	public void setQuestion(QuestionWithBLOBs question) {
		this.question = question;
	}

	public PaperDetail getPaperDetail() {
		return paperDetail;
	}

	public void setPaperDetail(PaperDetail paperDetail) {
		this.paperDetail = paperDetail;
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

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getQtype() {
        return qtype;
    }

    public void setQtype(Integer qtype) {
        this.qtype = qtype;
    }
}