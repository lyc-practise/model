package com.wsgw;

import java.util.Arrays;
import java.util.List;

public class GenerateSql {

    public static void main(String[] args) {

        List<String> exhibitionIdList = Arrays.asList("1000088","1000089","1000090","1000091","1000092","1000108");
        List<String> cityIdList = Arrays.asList("999999","210000","320000","360000","430000","630000","500000","110000","120000","130000","140000","150000","220000","230000","310000","330000","340000","350000","370000","410000","420000","510000","540000","620000","640000","650000","610000");
        List<String> sortList = Arrays.asList("1","2","3","4","5");

        String priority = "1";

//        System.out.println("--==============  优先级为1的初始化数据  ===================--");
//        for(int i = 0 ; i < exhibitionIdList.size() ;i++){
//            for(int j = 0 ; j < cityIdList.size(); j++){
//                for(int z = 0 ; z < sortList.size() ; z++){
//                    System.out.println("insert into OMGMT_EXHIBITION_PRODUCT (EXHIBITION_PRODUCT_ID, EXHIBITION_ID, PRODUCT_ID, CITY_ID, PRIORITY, SORT, CREATE_AT, MODIFY_AT )" +
//                            " values (sys_guid(), '" + exhibitionIdList.get(i) + "', sys_guid(),'" + cityIdList.get(j) + "', '" + priority + "'," + sortList.get(z) + ",current_timestamp(0),current_timestamp(0));");
//                }
//            }
//        }


//        System.out.println("--==============  优先级为0的初始化数据  ===================--");
//        priority = "0";
//        for(int i = 0 ; i < exhibitionIdList.size() ;i++){
//            for(int j = 0 ; j < cityIdList.size(); j++){
//                for(int z = 0 ; z < sortList.size() ; z++){
//                    System.out.println("insert into OMGMT_EXHIBITION_PRODUCT (EXHIBITION_PRODUCT_ID, EXHIBITION_ID, PRODUCT_ID, CITY_ID, PRIORITY, SORT, CREATE_AT, MODIFY_AT )" +
//                            " values (sys_guid(), '" + exhibitionIdList.get(i) + "', sys_guid(),'" + cityIdList.get(j) + "', '" + priority + "'," + sortList.get(z) + ",current_timestamp(0),current_timestamp(0));");
//                }
//            }
//        }

//
//        List<String> groupIdList = Arrays.asList("14","15","16","17","18","22");
//        exhibitionIdList = Arrays.asList("1000088","1000089","1000090","1000091","1000092","1000108");
//        System.out.println("--==============  初始化固定展台和展台组的关系  ===================--");
//        for(int i = 0; i < groupIdList.size(); i++){
//            for(int j = 0 ; j < cityIdList.size(); j++){
//                System.out.println("insert into OMGMT_GROUP_EXHIBITION_REL (GROUP_EXHIBITION_ID, GROUP_ID, EXHIBITION_ID, CITY_ID, SORT, CREATE_AT, MODIFY_AT) values (sys_guid(), '"+ groupIdList.get(i) +"', '"+ exhibitionIdList.get(i) +"', '"+cityIdList.get(j)+"', 1, current_timestamp(0), current_timestamp(0));");
//            }
//        }


    }
}
