package cn.shaines.filesystem.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * <p></p>
 * @author: yc
 * @date 2019/12/10 16:52
 */
@Component
@ConfigurationProperties(prefix = "pageoffice.reg")
public class PageOfficeEntry {

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

    public PageOfficeEntry() {
    }

    public String getSysPath() {
        return sysPath;
    }

    public void setSysPath(String sysPath) {
        this.sysPath = sysPath;
    }

    public String getPoServerUrl() {
        return poServerUrl;
    }

    public void setPoServerUrl(String poServerUrl) {
        this.poServerUrl = poServerUrl;
    }

    public String getPoSetup() {
        return poSetup;
    }

    public void setPoSetup(String poSetup) {
        this.poSetup = poSetup;
    }

    public String getPageofficeJs() {
        return pageofficeJs;
    }

    public void setPageofficeJs(String pageofficeJs) {
        this.pageofficeJs = pageofficeJs;
    }

    public String getJqueryUrl() {
        return jqueryUrl;
    }

    public void setJqueryUrl(String jqueryUrl) {
        this.jqueryUrl = jqueryUrl;
    }

    public String getPobstyleCssUrl() {
        return pobstyleCssUrl;
    }

    public void setPobstyleCssUrl(String pobstyleCssUrl) {
        this.pobstyleCssUrl = pobstyleCssUrl;
    }

    public String getSealSetup() {
        return sealSetup;
    }

    public void setSealSetup(String sealSetup) {
        this.sealSetup = sealSetup;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminSeal() {
        return adminSeal;
    }

    public void setAdminSeal(String adminSeal) {
        this.adminSeal = adminSeal;
    }

    public String getSealImage() {
        return sealImage;
    }

    public void setSealImage(String sealImage) {
        this.sealImage = sealImage;
    }

    public String getLoginSeal() {
        return loginSeal;
    }

    public void setLoginSeal(String loginSeal) {
        this.loginSeal = loginSeal;
    }

    @Override
    public String toString() {
        return "PageOfficeEntry{" +
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
}
