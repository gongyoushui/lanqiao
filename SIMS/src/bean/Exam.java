package bean;

import java.sql.Time;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Exam {

    private Integer exam_id;
    private String exam_name;
    private String time;
    private String type;
    private Integer lesson_id;
    private String exam_grade;
    private String exam_class;
    private String exam_tips;

    public Exam() {
    }

    public Exam(Integer exam_id, String exam_name, String time, String type, Integer lesson_id, String exam_grade, String exam_class, String exam_tips) {
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.time = time;
        this.type = type;
        this.lesson_id = lesson_id;
        this.exam_grade = exam_grade;
        this.exam_class = exam_class;
        this.exam_tips = exam_tips;
    }

    public String getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(String exam_grade) {
        this.exam_grade = exam_grade;
    }

    public String getExam_class() {
        return exam_class;
    }

    public void setExam_class(String exam_class) {
        this.exam_class = exam_class;
    }

    public String getExam_tips() {
        return exam_tips;
    }

    public void setExam_tips(String exam_tips) {
        this.exam_tips = exam_tips;
    }

    public Integer getExam_id() {
        return exam_id;
    }

    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Integer lesson_id) {
        this.lesson_id = lesson_id;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_id=" + exam_id +
                ", exam_name='" + exam_name + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", lesson_id=" + lesson_id +
                '}';
    }
}
