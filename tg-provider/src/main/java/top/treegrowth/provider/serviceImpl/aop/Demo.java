package top.treegrowth.provider.serviceImpl.aop;

import java.lang.annotation.*;

/**
 * @author wusi
 * @version 2017/3/18 8:24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Demo {

    String name();
}
