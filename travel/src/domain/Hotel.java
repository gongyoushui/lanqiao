package domain;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Hotel {
    private int h_id;
    private int sto_id;
    private String h_type;
    private int h_price;
    private  int h_discount;

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public String getH_type() {
        return h_type;
    }

    public void setH_type(String h_type) {
        this.h_type = h_type;
    }

    public int getH_price() {
        return h_price;
    }

    public void setH_price(int h_price) {
        this.h_price = h_price;
    }

    public int getH_discount() {
        return h_discount;
    }

    public void setH_discount(int h_discount) {
        this.h_discount = h_discount;
    }

    public String [] toStringArray(){
        return new String[]{
                h_type+h_price+h_discount
        };
    }
}
