package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Exam_Class {

    private Integer ec_id;
    private Integer exam_id;
    private Integer class_id;

    public Exam_Class() {
    }

    public Exam_Class(Integer ec_id, Integer exam_id, Integer class_id) {
        this.ec_id = ec_id;
        this.exam_id = exam_id;
        this.class_id = class_id;
    }

    public Integer getEc_id() {
        return ec_id;
    }

    public void setEc_id(Integer ec_id) {
        this.ec_id = ec_id;
    }

    public Integer getExam_id() {
        return exam_id;
    }

    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Exam_Class{" +
                "ec_id=" + ec_id +
                ", exam_id=" + exam_id +
                ", class_id=" + class_id +
                '}';
    }
}
