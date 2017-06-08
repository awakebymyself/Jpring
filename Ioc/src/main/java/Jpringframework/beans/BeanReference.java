package Jpringframework.beans;

/**
 * @auther by jack on 下午10:38 17-5-22.
 * @Email lzgsshen@163.com
 */
public class BeanReference {

    private String name;

    private Object value;

    public BeanReference(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
