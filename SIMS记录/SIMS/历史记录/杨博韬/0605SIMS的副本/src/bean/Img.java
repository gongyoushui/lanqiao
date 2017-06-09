package bean;

/**
 * Created by lanqiao on 2017/6/5.
 */
public class Img {

    private Integer img_id;
    private Byte img;

    public Img() {
    }

    public Img(Integer img_id, Byte img) {
        this.img_id = img_id;
        this.img = img;
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Byte getImg() {
        return img;
    }

    public void setImg(Byte img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Img{" +
                "img_id=" + img_id +
                ", img=" + img +
                '}';
    }
}
