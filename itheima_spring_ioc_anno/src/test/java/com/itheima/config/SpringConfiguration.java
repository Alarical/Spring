package com.itheima.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configurable
@ComponentScan("com.itheima")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
