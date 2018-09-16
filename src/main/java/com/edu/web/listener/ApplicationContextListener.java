package com.edu.web.listener;

import com.edu.pojo.Province;
import com.edu.service.ProvinceService;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;

public class ApplicationContextListener extends ContextLoaderListener {
    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        WebApplicationContext webApplicationContext = super.initWebApplicationContext(servletContext);
        ProvinceService ps = webApplicationContext.getBean(ProvinceService.class);
        List<Province> provinces = ps.selectAll();
        servletContext.setAttribute("province",provinces);

        return webApplicationContext;
    }
}
