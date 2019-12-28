package kr.p.eye.platform.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = "kr.p.eye.platform", useDefaultFilters = false, includeFilters = {
		@Filter(type = FilterType.REGEX, pattern = "kr.p.eye.platform.*.*Dao"),
		@Filter(type = FilterType.REGEX, pattern = "kr.p.eye.platform.*.*Service"),
		@Filter(type = FilterType.REGEX, pattern = "kr.p.eye.platform.*.*ServiceImpl")})
@Import(DBConfig.class)
public class ApplicationConfig {

}
