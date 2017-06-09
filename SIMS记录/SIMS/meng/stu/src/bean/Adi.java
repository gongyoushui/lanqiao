package bean;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class Adi {
    private Integer adi_id;
    private String adi_name;
    private String adi_pwd;
    private String adi_status;

    public Adi() {
    }

    public Adi(String adi_name, String adi_pwd) {
        this.adi_name = adi_name;
        this.adi_pwd = adi_pwd;
    }

    public Integer getAdi_id() {
        return adi_id;
    }

    public void setAdi_id(Integer adi_id) {
        this.adi_id = adi_id;
    }

    public String getAdi_name() {
        return adi_name;
    }

    public void setAdi_name(String adi_name) {
        this.adi_name = adi_name;
    }

    public String getAdi_pwd() {
        return adi_pwd;
    }

    public void setAdi_pwd(String adi_pwd) {
        this.adi_pwd = adi_pwd;
    }

    public String getAdi_status() {
        return adi_status;
    }

    public void setAdi_status(String adi_status) {
        this.adi_status = adi_status;
    }

    @Override
    public String toString() {
        return "Adi{" +
                "adi_id=" + adi_id +
                ", adi_name='" + adi_name + '\'' +
                ", adi_pwd='" + adi_pwd + '\'' +
                ", adi_status='" + adi_status + '\'' +
                '}';
    }
}
