package Jpringframework.beans.factory;

/**
 * @auther by jack on 17-4-12.
 * @Time 下午2:01
 * @Email lzgsshen@163.com
 */
public class HiService {

    private String text;

    private Girl girl;

    String getStr() {
        return "";
    }

    public String getResult() {
        return girl.smile() + ":" + text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
