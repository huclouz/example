package com.huttchang.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 해당 ViewResolver는 application.properties에서 정의 하나
 * Resource path설정은 여기서 처리를 하기 위하여 따로 빼 놓음
 */
@Configuration
public class ViewResolverConfiguration extends WebMvcConfigurerAdapter {

    @Value("spring.view.prefix")
    private String viewPrefix;

    @Value("spring.view.suffix")
    private String viewSuffix;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
