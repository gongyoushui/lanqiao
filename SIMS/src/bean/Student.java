package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Student {

    private Integer student_id;
    private String student_name;
    private String student_code;
    private String sex;
    private Integer class_id;
    private Integer phone;
    private Integer qq;
    private String mail;
    private String tips;

    public Student() {
    }

    public Student(Integer student_id, String student_name, String student_code, String sex, Integer class_id, Integer phone, Integer qq, String mail, String tips) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_code = student_code;
        this.sex = sex;
        this.class_id = class_id;
        this.phone = phone;
        this.qq = qq;
        this.mail = mail;
        this.tips = tips;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
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
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_code='" + student_code + '\'' +
                ", sex='" + sex + '\'' +
                ", class_id=" + class_id +
                ", phone=" + phone +
                ", qq=" + qq +
                ", mail='" + mail + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
