package org.blog.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/upload-dir/**").addResourceLocations("file:///C:/Users/Zulu/IdeaProjects/blog/upload-dir/");
    }
}
