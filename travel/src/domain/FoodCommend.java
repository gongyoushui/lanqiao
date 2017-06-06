package domain;

/**
 * Created by Administrator on 2017/4/29.
 * Sight,store ,foods 领域对象
 */

public class FoodCommend {
    private String si_name;
    private String s_name;
    private  String f_name;
    private int  f_price;
    private String sto_name;
    private int f_discount;
    private String f_pic;
    private String f_type;

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }

    public String getF_pic() {
        return f_pic;
    }

    public void setF_pic(String f_pic) {
        this.f_pic = f_pic;
    }

    public String getSi_name() {
        return si_name;
    }

    public void setSi_name(String si_name) {
        this.si_name = si_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public int  getF_price() {
        return f_price;
    }

    public void setF_price(int  f_price) {
        this.f_price = f_price;
    }

    public String getSto_name() {
        return sto_name;
    }

    public void setSto_name(String sto_name) {
        this.sto_name = sto_name;
    }

    public int getF_discount() {
        return f_discount;
    }

    public void setF_discount(int f_discount) {
        this.f_discount = f_discount;
    }
    public String[] toStringArray(){

        return new String[]{
                f_name , String.valueOf(f_price) , String.valueOf(f_discount)
        };
    }
}
