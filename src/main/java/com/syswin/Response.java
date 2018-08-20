package com.syswin;

import com.alibaba.fastjson.JSON;
import com.param.AppInfoResParam;
import com.param.DeptInfoResParam;
import com.param.MemberInfoResParam;

import java.util.ArrayList;
import java.util.List;

public class Response {

    public static void main(String[] args) {

        success();

    }

    private static void success(){
        System.out.println(JSON.toJSONString(ResponseResult.success(null)));
    }

    private static void fial(){
//        System.out.println(JSON.toJSONString(ResponseResult.fa));
    }

    private static void appList(){
        List<AppInfoResParam> apps = new ArrayList<>();
        AppInfoResParam app1 = new AppInfoResParam();
        app1.setAppId(1l);
        app1.setAppName("打卡系统");
        app1.setAppUrl("http://laksdjalsd.com");
        app1.setOrdinal(1l);
        app1.setOrgId(1l);
        app1.setGroupSign("groupBuild");

        AppInfoResParam app2 = new AppInfoResParam();
        app2.setAppId(2l);
        app2.setAppName("请假系统");
        app2.setAppUrl("http://laksdjalsd.com");
        app2.setOrdinal(2l);
        app2.setOrgId(2l);
        app2.setGroupSign("groupBuild");

        apps.add(app1);
        apps.add(app2);

        System.out.println(JSON.toJSONString(ResponseResult.success(apps)));


    }


    private static void member(){

        MemberInfoResParam mem1 = new MemberInfoResParam();
        mem1.setMemberId(1l);
        mem1.setSex("male");
        mem1.setEmail("abc@syswin.com");
        mem1.setMobile("1386666666");
        mem1.setOrdinal(1l);

        System.out.println(JSON.toJSONString(ResponseResult.success(mem1)));
    }

    private static void memberList(){

        List<MemberInfoResParam> memberInfoResParams = new ArrayList<>();
        MemberInfoResParam mem1 = new MemberInfoResParam();
        mem1.setMemberId(1l);
        mem1.setSex("male");
        mem1.setEmail("abc@syswin.com");
        mem1.setMobile("1386666666");
        mem1.setOrdinal(1l);

        MemberInfoResParam mem2 = new MemberInfoResParam();
        mem2.setMemberId(1l);
        mem2.setSex("male");
        mem2.setEmail("abc@syswin.com");
        mem2.setMobile("1386666666");
        mem2.setOrdinal(1l);

        memberInfoResParams.add(mem1);
        memberInfoResParams.add(mem2);

        System.out.println(JSON.toJSONString(ResponseResult.success(memberInfoResParams)));
    }

    private static void departmentList(){

        List<DeptInfoResParam> deptInfoRes = new ArrayList<>();
        DeptInfoResParam res1 = new DeptInfoResParam();
        res1.setDeptId(3l);
        res1.setParentId(1l);
        res1.setDeptCode("003");
        res1.setMemberCount(5);
        res1.setLayer(2);
        res1.setDeptName("行政办公室");

        DeptInfoResParam res2 = new DeptInfoResParam();
        res2.setDeptId(4l);
        res1.setParentId(1l);
        res2.setDeptCode("004");
        res2.setMemberCount(5);
        res2.setLayer(2);
        res2.setDeptName("财务办公室");


        deptInfoRes.add(res1);
        deptInfoRes.add(res2);

        ResponseResult<List<DeptInfoResParam>> responseResult = ResponseResult.success(deptInfoRes);

        System.out.println(JSON.toJSONString(responseResult));

    }
}
