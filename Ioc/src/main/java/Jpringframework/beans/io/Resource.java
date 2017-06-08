package Jpringframework.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther by jack on 下午6:14 17-4-14.
 * @Email lzgsshen@163.com
 * Spring 内资源内外接口
 */
@FunctionalInterface
public interface Resource {

    InputStream getInputStream() throws IOException;

}
