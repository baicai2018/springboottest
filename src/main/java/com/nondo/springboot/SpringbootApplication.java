package com.nondo.springboot;

import com.nondo.maven.conf.EncodingConvertorConfiguration;
import com.nondo.maven.filter.TimeFilter;
import com.nondo.maven.listener.ListenerTest;
import com.nondo.maven.servlet.ServletTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@SpringBootApplication
@Import(EncodingConvertorConfiguration.class)
public class SpringbootApplication extends SpringBootServletInitializer implements ServletContextInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //配置servlet
        servletContext.addServlet("testServlet",new ServletTest())
                .addMapping("/servlet/test");
        //配置过滤器
        servletContext.addFilter("timeFilter",new TimeFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
        //配置监听器
        servletContext.addListener(new ListenerTest());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//        System.out.println(System.getProperty("file.encoding"));
//        Map<String,EncodingConvertor> map = context.getBeansOfType(EncodingConvertor.class);
//        System.out.println(map);
//        CacheConfirguration config = context.getBean(CacheConfirguration.class);
//        System.out.println(config);
//        Cache cache = context.getBean(Cache.class);
//        System.out.println(cache);
    }
}