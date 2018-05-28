package springblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@ComponentScan("springblog.controller")
public class SpringBlogWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected String[] getServletMappings(){
		return new String[]{"/"};
	}

	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses(){
		return new Class<?>[]{WebConfig.class};
	}

}
