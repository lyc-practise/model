package com.param;


import java.util.List;

/**
 * Created by wuyuting on 2018/3/31.
 */

public class TreeNodeResParam {

    private String text;
    private int id;
    private String parent;
    private int parentId;
    private Integer layer;
    private String agentManagerId;
    private Boolean manageAccountBySelf;
    private List<TreeNodeResParam> children;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public String getAgentManagerId() {
        return agentManagerId;
    }

    public void setAgentManagerId(String agentManagerId) {
        this.agentManagerId = agentManagerId;
    }

    public Boolean getManageAccountBySelf() {
        return manageAccountBySelf;
    }

    public void setManageAccountBySelf(Boolean manageAccountBySelf) {
        this.manageAccountBySelf = manageAccountBySelf;
    }

    public List<TreeNodeResParam> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeResParam> children) {
        this.children = children;
    }
}
