package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Lesson {

    private Integer lesson_id;
    private String  lesson_name;

    public Lesson() {
    }

    public Lesson(Integer lesson_id, String lesson_name) {
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
    }

    public Integer getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Integer lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lesson_id=" + lesson_id +
                ", lesson_name='" + lesson_name + '\'' +
                '}';
    }
}
