package Jpringframework.beans.factory;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @auther by jack on 下午5:26 17-4-17.
 * @Email lzgsshen@163.com
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void xmlReaderTest() throws Exception {
        InputStream inputStream = XmlBeanDefinitionReaderTest.class
                .getClassLoader().getResourceAsStream("test.xml");

        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader();
        definitionReader.loadBeanDefinitions(() -> inputStream);
        assertEquals(1, definitionReader.getMap().size());
        assertTrue(definitionReader.getMap().containsKey("test"));
    }

}