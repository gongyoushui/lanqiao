package domain;

/**
 * Created by Administrator on 2017/4/28.
 */
public class User_Collection {
    private int uc_id;
    private int u_id;
    private int c_id;
    private String c_name;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public int getUc_id() {
        return uc_id;
    }

    public void setUc_id(int uc_id) {
        this.uc_id = uc_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
//    public String toString (){
//        return String.valueOf(uc_id+u_id+c_id);
//    }
}
