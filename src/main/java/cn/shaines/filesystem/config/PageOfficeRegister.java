package cn.shaines.filesystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pageoffice.reg")
public class PageOfficeRegister {

    private String sysPath;
    private String poServerUrl;
    private String poSetup;
    private String pageofficeJs;
    private String jqueryUrl;
    private String pobstyleCssUrl;
    private String sealSetup;

    private String adminPassword;
    private String adminSeal;
    private String sealImage;
    private String loginSeal;



    public void setSysPath(String sysPath) {
        this.sysPath = sysPath;
    }


    public void setPoServerUrl(String poServerUrl) {
        this.poServerUrl = poServerUrl;
    }



    public void setPoSetup(String poSetup) {
        this.poSetup = poSetup;
    }



    public void setPageofficeJs(String pageofficeJs) {
        this.pageofficeJs = pageofficeJs;
    }



    public void setJqueryUrl(String jqueryUrl) {
        this.jqueryUrl = jqueryUrl;
    }



    public void setPobstyleCssUrl(String pobstyleCssUrl) {
        this.pobstyleCssUrl = pobstyleCssUrl;
    }



    public void setSealSetup(String sealSetup) {
        this.sealSetup = sealSetup;
    }



    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }



    public void setAdminSeal(String adminSeal) {
        this.adminSeal = adminSeal;
    }



    public void setSealImage(String sealImage) {
        this.sealImage = sealImage;
    }



    public void setLoginSeal(String loginSeal) {
        this.loginSeal = loginSeal;
    }

    @Override
    public String toString() {
        return "PageOfficeRegister{" +
                "sysPath='" + sysPath + '\'' +
                ", poServerUrl='" + poServerUrl + '\'' +
                ", poSetup='" + poSetup + '\'' +
                ", pageofficeJs='" + pageofficeJs + '\'' +
                ", jqueryUrl='" + jqueryUrl + '\'' +
                ", pobstyleCssUrl='" + pobstyleCssUrl + '\'' +
                ", sealSetup='" + sealSetup + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminSeal='" + adminSeal + '\'' +
                ", sealImage='" + sealImage + '\'' +
                ", loginSeal='" + loginSeal + '\'' +
                '}';
    }


    /**
     * 添加PageOffice的服务器端授权程序Servlet（必须）
     */
    @Bean
    public ServletRegistrationBean authServletRegistrationBean(){

        com.zhuozhengsoft.pageoffice.poserver.Server poserver = new com.zhuozhengsoft.pageoffice.poserver.Server();
        //设置PageOffice注册成功后,license.lic文件存放的目录
        poserver.setSysPath(this.sysPath);
        ServletRegistrationBean srb = new ServletRegistrationBean(poserver);

        srb.addUrlMappings(this.poServerUrl);
        srb.addUrlMappings(this.poSetup);
        srb.addUrlMappings(this.pageofficeJs);
        srb.addUrlMappings(this.jqueryUrl);
        srb.addUrlMappings(this.pobstyleCssUrl);
        srb.addUrlMappings(this.sealSetup);

        return srb;
    }

    /**
     * 添加印章管理程序Servlet（可选）
     */
    @Bean
    public ServletRegistrationBean sealServletRegistrationBean() {
        com.zhuozhengsoft.pageoffice.poserver.AdminSeal adminSeal = new com.zhuozhengsoft.pageoffice.poserver.AdminSeal();
        adminSeal.setAdminPassword(this.adminPassword);//设置印章管理员admin的登录密码
        adminSeal.setSysPath(this.sysPath);//印章数据库文件poseal.db的存放目录
        ServletRegistrationBean srb = new ServletRegistrationBean(adminSeal);
        srb.addUrlMappings(this.adminSeal);
        srb.addUrlMappings(this.sealImage);
        srb.addUrlMappings(this.loginSeal);
        return srb;
    }

}
