package Jpringframework.beans.factory;

import Jpringframework.beans.PropertyValue;
import Jpringframework.beans.PropertyValues;

/**
 * @auther by jack on 下午4:25 17-4-17.
 * @Email lzgsshen@163.com
 * 保存bean的一些属性,spring中是接口,我们这里简单起见
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues values = new PropertyValues();

    private PropertyValue propertyValue;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException ignored) {}
    }

    public PropertyValues getValues() {
        return values;
    }

    public void setValues(PropertyValues values) {
        this.values = values;
    }


}
