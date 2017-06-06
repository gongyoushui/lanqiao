package domain;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Foods {
    private int  f_id;
    private String f_name;
    private int f_price;
    private int f_discount;
    private String f_type;
    private int sto_id;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public int getF_price() {
        return f_price;
    }

    public void setF_price(int f_price) {
        this.f_price = f_price;
    }

    public int getF_discount() {
        return f_discount;
    }

    public void setF_discount(int f_discount) {
        this.f_discount = f_discount;
    }

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }
    public String[] toSrtingArray(){

        return new String[]{
                f_name + f_price + f_discount
        };
    }
}

