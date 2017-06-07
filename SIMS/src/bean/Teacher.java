package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Teacher {

    private Integer teacher_id;
    private String teacher_name;
    private String teacher_code;
    private String sex;
    private Integer phone;
    private Integer qq;
    private String mail;
    private String tips;

    public Teacher() {
    }

    public Teacher(Integer teacher_id, String teacher_name, String teacher_code, String sex, Integer phone, Integer qq, String mail, String tips) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_code = teacher_code;
        this.sex = sex;
        this.phone = phone;
        this.qq = qq;
        this.mail = mail;
        this.tips = tips;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_code() {
        return teacher_code;
    }

    public void setTeacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_code='" + teacher_code + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", qq=" + qq +
                ", mail='" + mail + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
