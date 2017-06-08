package Jpringframework.beans.factory;

import Jpringframework.beans.io.Resource;

/**
 * @auther by jack on 下午2:56 17-4-17.
 * @Email lzgsshen@163.com
 */
@FunctionalInterface
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource resource) throws Exception;

}
