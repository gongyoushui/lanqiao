package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Score {

    private Integer score_id;
    private Integer teacher_id;
    private Integer class_id;
    private Integer lesson_id;
    private Float score;

    public Score() {
    }

    public Score(Integer score_id, Integer teacher_id, Integer class_id, Integer lesson_id, Float score) {
        this.score_id = score_id;
        this.teacher_id = teacher_id;
        this.class_id = class_id;
        this.lesson_id = lesson_id;
        this.score = score;
    }

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score_id=" + score_id +
                ", teacher_id=" + teacher_id +
                ", class_id=" + class_id +
                ", lesson_id=" + lesson_id +
                ", score=" + score +
                '}';
    }
}
