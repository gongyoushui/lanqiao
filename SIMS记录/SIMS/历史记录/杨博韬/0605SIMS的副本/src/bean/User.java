package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class User {

    private Integer user_id;
    private String user_code;
    private String user_pass;
    private Integer type;

    public User() {
    }

    public User(Integer user_id, String user_code, String user_pass, Integer type) {
        this.user_id = user_id;
        this.user_code = user_code;
        this.user_pass = user_pass;
        this.type = type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_code='" + user_code + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", type=" + type +
                '}';
    }
}
