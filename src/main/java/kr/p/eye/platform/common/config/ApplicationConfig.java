package kr.p.eye.platform.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.p.eye.platform.member", "kr.p.eye.platform.category", "kr.p.eye.platform.product"})
@Import(DBConfig.class)
public class ApplicationConfig {

}
