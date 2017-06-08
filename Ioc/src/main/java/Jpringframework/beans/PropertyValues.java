package Jpringframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther by jack on 下午5:15 17-4-17.
 * @Email lzgsshen@163.com
 */
public class PropertyValues {

    private List<PropertyValue> values = new ArrayList<>();

    public List<PropertyValue> getValues() {
        return values;
    }

    public void addPropertyValue(PropertyValue value) {
        values.add(value);
    }

}
