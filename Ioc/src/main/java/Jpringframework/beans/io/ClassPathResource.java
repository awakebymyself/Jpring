package Jpringframework.beans.io;

import Jpringframework.beans.util.Assert;
import Jpringframework.beans.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @auther by jack on 下午1:36 17-4-17.
 * @Email lzgsshen@163.com
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;
    private Class<?> clazz;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, Class<?> clazz) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.clazz = clazz;
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream in;
        if (clazz != null) {
            in = clazz.getResourceAsStream(path);
        } else if (classLoader != null) {
            in = classLoader.getResourceAsStream(path);
        } else {
            in = ClassLoader.getSystemResourceAsStream(path);
        }
        if (in == null) {
            throw new FileNotFoundException(path + "doesn't exist");
        }
        return in;
    }

}
