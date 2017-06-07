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

    public Exam() {
    }

    public Exam(Integer exam_id, String exam_name, String time, String type, Integer lesson_id) {
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.time = time;
        this.type = type;
        this.lesson_id = lesson_id;
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
