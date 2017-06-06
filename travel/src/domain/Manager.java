package domain;

/**
 * Created by Administrator on 2017/4/27.
 */
public class Manager {
    private int M_ID;
    private String M_NAME;
    private String M_PASS_WORD;

    public int getM_ID() {
        return M_ID;
    }

    public void setM_ID(int m_ID) {
        M_ID = m_ID;
    }

    public String getM_NAME() {
        return M_NAME;
    }

    public void setM_NAME(String m_NAME) {
        M_NAME = m_NAME;
    }

    public String getM_PASS_WORD() {
        return M_PASS_WORD;
    }

    public void setM_PASS_WORD(String m_PASS_WORD) {
        M_PASS_WORD = m_PASS_WORD;
    }

    public String[] toStringArray(){
        return new String[]{
                String.valueOf(M_ID),
                M_NAME,
                M_PASS_WORD
        };
    }

    public String toString(){
        return "M_ID="+M_ID+"M_NAME="+M_NAME+"M_PASS_WORD="+M_PASS_WORD;
    }
}
