package com.param;

import com.test.LongTest;

import java.util.ArrayList;
import java.util.List;

public class ParentDeptMapParam {
    private Long deptId;
    private Long orgId;
    private String deptName;
    private String deptCode;
    private Integer lft;
    private Integer rgt;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1l);


        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}
