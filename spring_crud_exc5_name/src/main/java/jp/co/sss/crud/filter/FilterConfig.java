package jp.co.sss.crud.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
	/*	@Bean
		public FilterRegistrationBean<AccountCheckFilter> configAccountCheckFilter() {
			FilterRegistrationBean<AccountCheckFilter> bean = new FilterRegistrationBean<AccountCheckFilter>();
	
			bean.setFilter(new AccountCheckFilter());
			bean.setOrder(2);
			return bean;
		}*/

	@Bean
	public FilterRegistrationBean<LoginCheckFilter> configLoginCheckFilter() {
		FilterRegistrationBean<LoginCheckFilter> bean = new FilterRegistrationBean<LoginCheckFilter>();

		bean.setFilter(new LoginCheckFilter());
		bean.setOrder(1);
		return bean;
	}
}