package domain;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Store {
    private  int sto_id;
    private String sto_name;
    private String sto_type;
    private int s_id;

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public String getSto_name() {
        return sto_name;
    }

    public void setSto_name(String sto_name) {
        this.sto_name = sto_name;
    }

    public String getSto_type() {
        return sto_type;
    }

    public void setSto_type(String sto_type) {
        this.sto_type = sto_type;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

}
