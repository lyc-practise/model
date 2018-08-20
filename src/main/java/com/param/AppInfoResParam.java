package com.param;

public class AppInfoResParam  {

    //@ApiModelProperty(value = "应用名称")
    private String appName;
    //@ApiModelProperty(value = "应用图标")
    private String appIcon;
    //@ApiModelProperty(value = "应用ID")
    private Long appId;
    //@ApiModelProperty(value = "组织ID")
    private Long orgId;
    //@ApiModelProperty(value = "首页地址")
    private String appUrl;
    //@ApiModelProperty(value = "排序")
    private Long ordinal;

    private String groupSign;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Long getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Long ordinal) {
        this.ordinal = ordinal;
    }

    public String getGroupSign() {
        return groupSign;
    }

    public void setGroupSign(String groupSign) {
        this.groupSign = groupSign;
    }
}
