package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Notice {

    private Integer notice_id;
    private String notice;

    public Notice() {
    }

    public Notice(Integer notice_id, String notice) {
        this.notice_id = notice_id;
        this.notice = notice;
    }

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice='" + notice + '\'' +
                '}';
    }
}
