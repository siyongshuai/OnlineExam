package haue.edu.cn.model;

public class QuestionDBWithBLOBs extends QuestionDB {
    private String content;

    private String skey;

    private String keydesc;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    public String getKeydesc() {
        return keydesc;
    }

    public void setKeydesc(String keydesc) {
        this.keydesc = keydesc == null ? null : keydesc.trim();
    }
}