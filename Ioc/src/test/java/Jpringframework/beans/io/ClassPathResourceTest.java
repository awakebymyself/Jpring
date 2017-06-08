package Jpringframework.beans.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @auther by jack on 下午1:48 17-4-17.
 * @Email lzgsshen@163.com
 */
public class ClassPathResourceTest {

    @Test
    public void testGetResource() throws IOException {
        ClassPathResource resource = new ClassPathResource("beans.xml");
        assertNotNull(resource.getInputStream());
    }

}