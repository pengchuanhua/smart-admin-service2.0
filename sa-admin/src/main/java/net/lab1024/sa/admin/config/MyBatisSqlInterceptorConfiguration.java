package net.lab1024.sa.admin.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author pengch
 * @version 1.0
 * @date 2023/5/12 14:41
 * @since : JDK 11
 */
@Component
public class MyBatisSqlInterceptorConfiguration implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
        sqlSessionFactory.getConfiguration().addInterceptor(new SQLInterceptor());
    }
}
