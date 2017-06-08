package Jpringframework.beans.factory;

import Jpringframework.beans.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther by jack on 下午2:45 17-4-17.
 * @Email lzgsshen@163.com
 */
public class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> definitionMap = new ConcurrentHashMap<>();
    private List<String> beanNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition definition = definitionMap.get(name);
        Assert.notNull(definition, "Bean name hasn't not been registered ");
        Object bean = definition.getBean();
        if (bean == null) {
            bean = doCreateBean(definition);
        }
        return bean;
    }


    private Object doCreateBean(BeanDefinition definition) throws Exception {
        Object o = definition.getBeanClass().newInstance();
        definition.setBean(o);
        applyPropertyValues(o, definition);
        return o;
    }


    public void doRegisterBean(String name, BeanDefinition d) {
        definitionMap.put(name, d);
        beanNames.add(name);
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return null;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
    }
}
