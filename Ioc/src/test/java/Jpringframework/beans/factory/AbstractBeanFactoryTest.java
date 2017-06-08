package Jpringframework.beans.factory;

import Jpringframework.beans.io.Resource;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @auther by jack on 上午1:52 17-4-19.
 * @Email lzgsshen@163.com
 */
public class AbstractBeanFactoryTest {

    @Test
    public void testGetBean() throws Exception {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        reader.loadBeanDefinitions(new Resource() {
            @Override
            public InputStream getInputStream() throws IOException {
                return this.getClass().getClassLoader().getResourceAsStream("test.xml");
            }
        });

        AbstractBeanFactory factory = new AbstractBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : reader.getMap().entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition definition = entry.getValue();
            factory.doRegisterBean(beanName, definition);
        }
        HiService service = (HiService) factory.getBean("test");
        System.out.println(service.getStr());

    }



}