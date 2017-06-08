package Jpringframework.beans.factory;

import Jpringframework.beans.BeanReference;
import Jpringframework.beans.PropertyValue;
import Jpringframework.beans.io.Resource;
import Jpringframework.beans.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther by jack on 下午3:24 17-4-17.
 * @Email lzgsshen@163.com
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception {
        Assert.notNull(resource, "Resource must not be null");
        System.out.println("Loading XML bean definitions from " + resource);

        //省略spring 一些处理...
        try (InputStream inputStream = resource.getInputStream()) {
            loadBeanDefinitions(inputStream);
        }
    }

    private void loadBeanDefinitions(InputStream in) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(in);
        Element element = document.getDocumentElement();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                parseNode((Element) node);
            }
        }
    }

    private void parseNode(Element element) {
        String id = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition definition = new BeanDefinition();
        processProperty(element, definition);
        definition.setBeanClassName(className);
        map.put(id, definition);
    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element e = (Element) node;
                String name = e.getAttribute("name");
                String value = e.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = e.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("<Property> tag must specific a value or ref ");
                    }
                    BeanReference beanReference = new BeanReference(name, value);
                    beanDefinition.getValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

    public Map<String, BeanDefinition> getMap() {
        return map;
    }

}
