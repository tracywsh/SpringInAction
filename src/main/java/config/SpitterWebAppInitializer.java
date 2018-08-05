package config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		String path = SpitterWebAppInitializer.class.getResource("").getFile();
		path += "/temp/uploads";
		File file = new File(path);
		if (!file.exists()){
			file.mkdirs();
		}
		//设置上传文件的临时路径
		registration.setMultipartConfig(new MultipartConfigElement(path));
	}
	
	
}
