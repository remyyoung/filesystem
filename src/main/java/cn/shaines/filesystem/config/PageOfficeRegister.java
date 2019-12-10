package cn.shaines.filesystem.config;

import cn.shaines.filesystem.entity.PageOfficeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PageOfficeRegister {

    @Autowired
    private PageOfficeEntry pageOfficeEntry;



    /**
     * 添加PageOffice的服务器端授权程序Servlet（必须）
     */
    @Bean
    public ServletRegistrationBean authServletRegistrationBean(){

        com.zhuozhengsoft.pageoffice.poserver.Server poserver = new com.zhuozhengsoft.pageoffice.poserver.Server();
        //设置PageOffice注册成功后,license.lic文件存放的目录
        poserver.setSysPath(pageOfficeEntry.getSysPath());
        ServletRegistrationBean srb = new ServletRegistrationBean(poserver);

        srb.addUrlMappings(pageOfficeEntry.getPoServerUrl());
        srb.addUrlMappings(pageOfficeEntry.getPoSetup());
        srb.addUrlMappings(pageOfficeEntry.getPageofficeJs());
        srb.addUrlMappings(pageOfficeEntry.getJqueryUrl());
        srb.addUrlMappings(pageOfficeEntry.getPobstyleCssUrl());
        srb.addUrlMappings(pageOfficeEntry.getSealSetup());

        return srb;
    }

    /**
     * 添加印章管理程序Servlet（可选）
     */
    @Bean
    public ServletRegistrationBean sealServletRegistrationBean() {
        com.zhuozhengsoft.pageoffice.poserver.AdminSeal adminSeal = new com.zhuozhengsoft.pageoffice.poserver.AdminSeal();
        adminSeal.setAdminPassword(pageOfficeEntry.getAdminPassword());//设置印章管理员admin的登录密码
        adminSeal.setSysPath(pageOfficeEntry.getSysPath());//印章数据库文件poseal.db的存放目录
        ServletRegistrationBean srb = new ServletRegistrationBean(adminSeal);
        srb.addUrlMappings(pageOfficeEntry.getAdminSeal());
        srb.addUrlMappings(pageOfficeEntry.getSealImage());
        srb.addUrlMappings(pageOfficeEntry.getLoginSeal());
        return srb;
    }

}
