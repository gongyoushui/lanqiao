package domain;

/**
 * Created by Administrator on 2017/4/26.
 */
public class Sight {
    private int S_ID;
    private String S_NAME;
    private String S_LOC;
    private int S_PRICE;
    private int S_STU_PRICE;
    private String S_INTRODUCTION;
    private String S_lEVEL;

    public String getS_lEVEL() {
        return S_lEVEL;
    }

    public void setS_lEVEL(String s_lEVEL) {
        S_lEVEL = s_lEVEL;
    }

    private String S_PIC;

    public String getS_PIC() {
        return S_PIC;
    }

    public void setS_PIC(String s_PIC) {
        S_PIC = s_PIC;
    }

    public int getS_STU_PRICE() {
        return S_STU_PRICE;
    }

    public void setS_STU_PRICE(int s_STU_PRICE) {
        S_STU_PRICE = s_STU_PRICE;
    }





    public String getS_INTRODUCTION() {
        return S_INTRODUCTION;
    }

    public void setS_INTRODUCTION(String s_INTRODUCTION) {
        S_INTRODUCTION = s_INTRODUCTION;
    }

    private String S_SUM_ESSAY;
    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public String getS_NAME() {
        return S_NAME;
    }

    public void setS_NAME(String s_NAME) {
        S_NAME = s_NAME;
    }

    public String getS_LOC() {
        return S_LOC;
    }

    public void setS_LOC(String s_LOC) {
        S_LOC = s_LOC;
    }

    public int getS_PRICE() {
        return S_PRICE;
    }

    public void setS_PRICE(int s_PRICE) {
        S_PRICE = s_PRICE;
    }

    public String getS_SUM_ESSAY() {
        return S_SUM_ESSAY;
    }

    public void setS_SUM_ESSAY(String s_SUM_ESSAY) {
        S_SUM_ESSAY = s_SUM_ESSAY;
    }

    public String[] toStringArray(){
        return new String[]{
                S_NAME,S_SUM_ESSAY,S_INTRODUCTION,S_LOC,
                String.valueOf(S_PRICE),S_lEVEL
        };
    }
    public String toString(){
        return  S_NAME+S_SUM_ESSAY+S_INTRODUCTION+S_PIC;
    }
}
