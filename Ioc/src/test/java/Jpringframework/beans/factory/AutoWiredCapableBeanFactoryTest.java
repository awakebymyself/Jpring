package Jpringframework.beans.factory;

import Jpringframework.beans.io.Resource;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @auther by jack on 下午11:30 17-5-31.
 * @Email lzgsshen@163.com
 */
public class AutoWiredCapableBeanFactoryTest {

    @Test
    public void testAutoWire() throws Exception {
        //　获取资源
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test.xml");

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        Resource resource = () -> inputStream;
        reader.loadBeanDefinitions(resource);
        // 初始化工厂,并装载bean

        AutoWiredCapableBeanFactory factory = new AutoWiredCapableBeanFactory();
        reader.getMap().entrySet().stream().forEach(entry -> factory.doRegisterBean(entry.getKey(), entry.getValue()));
        HiService service = (HiService) factory.getBean("service");
        assertEquals("Smile:hello IOC", service.getResult());
    }

}