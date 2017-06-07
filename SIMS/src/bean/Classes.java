package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Classes {

    private Integer class_id;
    private String  class_name;
    private String  grade_name;

    public Classes() {
    }

    public Classes(Integer class_id, String class_name, String grade_name) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.grade_name = grade_name;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", grade_name='" + grade_name + '\'' +
                '}';
    }
}
