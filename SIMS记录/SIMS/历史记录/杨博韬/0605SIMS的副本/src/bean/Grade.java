package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Grade {

    private Integer grade_id;
    private String  grade_name;

    public Grade() {
    }

    public Grade(Integer grade_id, String grade_name) {
        this.grade_id = grade_id;
        this.grade_name = grade_name;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", grade_name='" + grade_name + '\'' +
                '}';
    }
}
