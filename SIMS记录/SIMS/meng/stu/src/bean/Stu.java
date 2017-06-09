package bean;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class Stu{
   private Integer stu_id;
   private String stu_name;
   private String stu_pwd;
   private String stu_status;

    public Stu() {
    }

    public Stu(String stu_name, String stu_status) {
        this.stu_name = stu_name;
        this.stu_status = stu_status;
    }

    public Stu(String stu_name,String stu_pwd,String stu_status){
        this.stu_name = stu_name;
        this.stu_pwd = stu_pwd;
        this.stu_status = stu_status;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_status() {
        return stu_status;
    }

    public void setStu_status(String stu_status) {
        this.stu_status = stu_status;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_status='" + stu_status + '\'' +
                '}';
    }
}
