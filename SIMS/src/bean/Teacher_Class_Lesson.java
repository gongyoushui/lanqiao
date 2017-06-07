package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Teacher_Class_Lesson {

    private Integer tcl_id;
    private Integer teacher_id;
    private Integer class_id;
    private Integer lesson_id;

    public Teacher_Class_Lesson() {
    }

    public Teacher_Class_Lesson(Integer tcl_id, Integer teacher_id, Integer class_id, Integer lesson_id) {
        this.tcl_id = tcl_id;
        this.teacher_id = teacher_id;
        this.class_id = class_id;
        this.lesson_id = lesson_id;
    }

    public Integer getTcl_id() {
        return tcl_id;
    }

    public void setTcl_id(Integer tcl_id) {
        this.tcl_id = tcl_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Integer lesson_id) {
        this.lesson_id = lesson_id;
    }

    @Override
    public String toString() {
        return "Teacher_Class_Lesson{" +
                "tcl_id=" + tcl_id +
                ", teacher_id=" + teacher_id +
                ", class_id=" + class_id +
                ", lesson_id=" + lesson_id +
                '}';
    }
}
