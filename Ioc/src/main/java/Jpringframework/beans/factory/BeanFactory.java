package Jpringframework.beans.factory;

/**
 * @auther by jack on 17-4-11.
 */
public interface BeanFactory {

    /**
     *
     * @param name bean name
     * @return an instance of the bean
     */
    Object getBean(String name);

    /**
     *
     * @param requiredType type the bean must match; can be an interface or superclass.
     * @return an instance of the single bean matching the required type
     */
    <T> T getBean(Class<T> requiredType);


}
