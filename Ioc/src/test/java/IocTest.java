import Jpringframework.beans.factory.HiService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @auther by jack on 17-4-12.
 * @Time 下午2:02
 * @Email lzgsshen@163.com
 */
public class IocTest {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println("numbers :" + factory.getBeanDefinitionCount());
        System.out.println(factory.getBean(HiService.class));

        //　这是传说的高富帅容器
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        System.out.println(context.getBean(Jpringframework.beans.factory.HiService.class).getStr());
    }
}
