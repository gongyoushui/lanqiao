package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Grade_Class {

    private Integer gl_id;
    private String grade_name;
    private Integer class_id;

    public Grade_Class() {
    }

    public Grade_Class(Integer gl_id, String grade_name, Integer class_id) {
        this.gl_id = gl_id;
        this.grade_name = grade_name;
        this.class_id = class_id;
    }

    public Integer getGl_id() {
        return gl_id;
    }

    public void setGl_id(Integer gl_id) {
        this.gl_id = gl_id;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Grade_Class{" +
                "gl_id=" + gl_id +
                ", grade_name='" + grade_name + '\'' +
                ", class_id=" + class_id +
                '}';
    }
}
