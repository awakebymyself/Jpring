*Jpring*

**致敬一下Spring, 参照写了一个小小的IOC,许多类名都取自Spring, 目前实现了自动装配.**

`xml`
    
    <bean id="service" class="Jpringframework.beans.factory.HiService">
        <property name="text" value="hello IOC"/>
        <property name="girl" ref="girl"/>  <!--自动装配属性-->
    </bean>

    <bean id="girl" class="Jpringframework.beans.factory.Girl"/>


`java`

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
        
    
*IOC的过程大体上其实就是定位资源，载入资源，初始化容器，装载bean工厂.*