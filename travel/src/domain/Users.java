package domain;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class Users {
    private int U_ID;
    private String U_NAME;
    private int U_PHONE_NUM;
    private String U_SEX;
    private String U_PASS_WORD;

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getU_NAME() {
        return U_NAME;
    }

    public void setU_NAME(String u_NAME) {
        U_NAME = u_NAME;
    }

    public int getU_PHONE_NUM() {
        return U_PHONE_NUM;
    }

    public void setU_PHONE_NUM(int u_PHONE_NUM) {
        U_PHONE_NUM = u_PHONE_NUM;
    }

    public String getU_SEX() {
        return U_SEX;
    }

    public void setU_SEX(String u_SEX) {
        U_SEX = u_SEX;
    }

    public String getU_PASS_WORD() {
        return U_PASS_WORD;
    }

    public void setU_PASS_WORD(String u_PASS_WORD) {
        U_PASS_WORD = u_PASS_WORD;
    }
    public String[] toStringArray(){
        return new String[]{
                String.valueOf(U_ID),
                U_NAME,
                String.valueOf(U_PHONE_NUM),
                U_SEX,
                U_PASS_WORD
        };
    }
    public String toString(){
        return "U_ID="+U_ID+"U_NAME="+U_NAME+"U_PHONE_NUM="+U_PHONE_NUM+"U_SEX="+U_SEX+"U_PASS_WORD="+U_PASS_WORD;
    }
}
