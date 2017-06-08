package Jpringframework.beans;

/**
 * @auther by jack on 下午5:15 17-4-17.
 * @Email lzgsshen@163.com
 */
public class PropertyValue {

    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
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
