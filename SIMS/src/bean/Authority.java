package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Authority {

    private String project;
    private Integer type;

    public Authority() {
    }

    public Authority(String project, Integer type) {
        this.project = project;
        this.type = type;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "project='" + project + '\'' +
                ", type=" + type +
                '}';
    }
}
