package Jpringframework.beans.factory;

import Jpringframework.beans.BeanReference;
import Jpringframework.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @auther by jack on 下午10:35 17-5-22.
 * @Email lzgsshen@163.com
 */
public class AutoWiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setFactory(this);
        }
        for (PropertyValue propertyValue :beanDefinition.getValues().getValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                value = getBean(((BeanReference) value).getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
