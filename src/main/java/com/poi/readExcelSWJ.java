package com.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelSWJ {
	public static void main(String[] args) {

		String fileDir = "/Users/tesla/Documents/消费市场情况0926/";
//		 1 各月社会消费品零售额
        readsxpfy(fileDir);
//		 2 各月社会消费品零售额分区县情况
//		readsxpfq(fileDir);
		// 3 各月服务性消费分类情况
//		readfwxffl(fileDir);
		// 4 各月限额以上批发零售贸易业企业分类零售额.
//		readxepflsqy(fileDir);
		// 5 限额以上零售企业分业态零售额
//		readxelsqylse(fileDir);
		// 6 重点流通企业监测系统百货商场销售额前20强
//		readbhsctop20(fileDir);
		// 7 重点流通企业监测系统餐饮企业营业额前20强.
//		readcyqytop20(fileDir);
		// 8 重点流通企业监测系统超市、便利店销售额前20强
//		readcstop20(fileDir);
		// 9 重点流通企业监测系统专业店及专卖店销售额前20强
//		readzmdtop20(fileDir);
    }

    // 1
	public static void readsxpfy(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "1.各月社会消费品零售额.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	            //获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            String type_name = "";
	            for (int i = 7; i<=rownum; i++) {
	            	row = sheet.getRow(i);
	            	if(i==9 || i==14 || i==19 || i==22){
	            		type_name = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
	            		continue;
	            	}else{
	            		if(i==7 || i==8){
	            			type_name = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
	            		}
	            		if(row !=null){
	            			type_name = type_name.substring(type_name.indexOf(".")+1).replaceAll(" ", "");
		                	String projectName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
		                	projectName = projectName.substring(projectName.indexOf(".")+1).replaceAll(" ", "");
		                	if(projectName!=null && !"".equals(projectName)){
		                		String sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', "+new BigDecimal(String.valueOf(row.getCell(1)))+", "+row.getCell(2)
			                    		+", "+new BigDecimal(String.valueOf(row.getCell(3)))+", "+row.getCell(4)+",'2019年','8月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(5)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(6))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(7)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(8))).trim()+"','2019年','7月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(9)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(10))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(11)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(12))).trim()+"','2019年','6月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(13)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(14))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(15)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(16))).trim()+"','2019年','5月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(17)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(18))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(19)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(20))).trim()+"','2019年','4月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp` (`type_name`,`porject_name`, `count`, `comp`, `total`,`total_comp`, `year`, `month`, `static_type`) VALUES ('"
			                    		+type_name.trim()+"', '"+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(21)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(22))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(23)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(24))).trim()+"','2019年','3月',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
		                	}
		                }else{
		                    break;
		                }
	            	}
	                
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}
	
	// 2
	public static void readsxpfq(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "2.各月社会消费品零售额分区县情况.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	        	//获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            //获取第一行
	            row = sheet.getRow(0);
	            //获取最大列数
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	            String type_name = "";
	            for (int i = 7; i<=rownum; i++) {
	            	row = sheet.getRow(i);

	            		if(row !=null){
							type_name = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
		                	String projectName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
		                	projectName = projectName.replaceAll(" ", "");
		                	projectName = projectName.substring(projectName.indexOf(".")+1).replaceAll(" ", "");
		                	if(projectName!=null && !"".equals(projectName)){
		                		String sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', "+new BigDecimal(String.valueOf(row.getCell(1)))+", "+row.getCell(2)
			                    		+", "+new BigDecimal(String.valueOf(row.getCell(3)))+", "+row.getCell(4)+",'2019-08-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(5)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(6))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(7)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(8))).trim()+"','2019-07-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(9)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(10))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(11)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(12))).trim()+"','2019-06-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(13)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(14))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(15)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(16))).trim()+"','2019-05-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(17)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(18))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(19)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(20))).trim()+"','2019-04-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
			                	sql = "INSERT INTO `shxfp_fq` (`porject_name`, `count`, `comp`, `total`,`total_comp`, `dateday`, `static_type`) VALUES ('"
			                    		+projectName.trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(21)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(22))).trim()
			                    		+"', '"+new BigDecimal(String.valueOf(row.getCell(23)))+"', '"+String.valueOf(getCellFormatValue(row.getCell(24))).trim()+"','2019-03-01',4)";
			                	System.out.println(sql);
			                	excuteSql(conn,sql);
		                	}
	                }else{
	                    break;
	                }
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	// 3
	public static void readfwxffl(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "3.各月服务性消费分类情况.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	            //获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            //获取第一行
	            for (int i = 7; i<=rownum; i++) {
	                row = sheet.getRow(i);
	                if(row !=null){
	                	String projectName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
	                	int group = 4;  // 一行几组数据
	                	int step = 4;	// 步长，一组几列
	                	String[] dateday = new String[]{"2019-06-01","2019-03-01","2018-12-01","2017-12-01"};
	                	for(int j = 0 ; j < group; j++){
							String sql = "INSERT INTO `fwxxf_fl` ( `project_name`,`this_period`, `same_period`, `speed`, `ratio`, `dateday`, `static_type`) VALUES ('"
									+projectName+"', "+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(1 + step * j))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)
									+", "+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(2 + step*j))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
									+String.valueOf(getCellFormatValue(row.getCell(3 + step*j))).trim()
									+"', '"+String.valueOf(getCellFormatValue(row.getCell(4 + step*j))).trim()+"','"
									+ dateday[j] + "','4')";
							System.out.println(sql);
							excuteSql(conn,sql);
						}

	                }else{
	                    break;
	                }
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	// 4
	public static void readxepflsqy(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "4.各月限额以上批发零售贸易业企业分类零售额.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	            //获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            for (int i = 6; i<rownum; i++) {
	                row = sheet.getRow(i);
	                if(row !=null){
	                	String projectName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
	                	if(projectName!=null && !"".equals(projectName)){
							int group = 8;
							int step = 5;
							String[] dateday = new String[]{"2019-08-01","2019-07-01","2019-06-01","2019-05-01","2019-04-01","2019-03-01","2019-02-01","2018-12-01"};
							for(int j = 0 ; j < group; j++) {
								String sql = "INSERT INTO `xepfls_fl` (`project_name`, `total`,`rise`, `devote`, `pull`, `ratio`, `dateday`, `static_type`) VALUES ('"
										+projectName+"', "
										+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(1 + step * j))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
										+String.valueOf(getCellFormatValue(row.getCell(2 + step*j))).trim()+"','"
										+String.valueOf(getCellFormatValue(row.getCell(3 + step*j))).trim()+"','"
										+String.valueOf(getCellFormatValue(row.getCell(4 + step*j))).trim()+"','"
										+String.valueOf(getCellFormatValue(row.getCell(5 + step*j))).trim()+"','"
										+ dateday[j] + "','4')";
								System.out.println(sql);
								excuteSql(conn, sql);
							}
	                	}
	                }else{
	                    break;
	                }
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	// 5
	public static void readxelsqylse(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "5.限额以上零售企业分业态零售额.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	            //获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            String typeName = "";
	            for (int i = 3; i<=rownum; i++) {
					row = sheet.getRow(i);
	            	if(i == 3 || i == 4){
	            		typeName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
	            		if(i==4){
	            			continue;
						}
					}
	                if(row !=null){
						String projectName = String.valueOf(getCellFormatValue(row.getCell(0))).trim();
						if(projectName!=null && !"".equals(projectName)){
							int group = 3;
							int step = 2;
							String[] dateday = new String[]{"2019-05-01","2019-04-01","2018-12-01"};
							for(int j = 0 ; j < group; j++) {
								String sql = "INSERT INTO `xelsqy_lse` (`type_name`,`project_name`, `total`,`speed`,  `dateday`, `static_type`) VALUES ('"
										+typeName+"', '"
										+projectName+"', "
										+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(1 + step * j))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
										+String.valueOf(getCellFormatValue(row.getCell(2 + step*j))).trim()+"','"
										+ dateday[j] + "','4')";
								System.out.println(sql);
								excuteSql(conn, sql);
							}
						}
	                }else{
	                    break;
	                }
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	//	6
	public static void readbhsctop20(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "6.2019年8月重点流通企业监测系统百货商场销售额前20强.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
	            //获取第一个sheet
	            sheet = wb.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getLastRowNum();
	            for (int i = 7; i<=rownum; i++) {
	                row = sheet.getRow(i);
	                if(row !=null){
						String projectName = String.valueOf(getCellFormatValue(row.getCell(1))).trim();
						if(projectName!=null && !"".equals(projectName)){
							String[] dateday = new String[]{"2019-08-01"};
							String sql = "INSERT INTO `bhsctop20` (`project_name`, `this_period`,`same_period`,  `rise`, `dateday`, `static_type`) VALUES ('"
									+projectName+"', "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(2 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(3 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
									+String.valueOf(getCellFormatValue(row.getCell(4))).trim()+"','"
									+ dateday[0] + "','4')";
							System.out.println(sql);
							excuteSql(conn, sql);
						}
	                	
	                }else{
	                    break;
	                }
	            }
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	// 7
	public static void readcyqytop20(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "7.2019年8月重点流通企业监测系统餐饮企业营业额前20强.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
				//获取第一个sheet
				sheet = wb.getSheetAt(0);
				//获取最大行数
				int rownum = sheet.getLastRowNum();
				for (int i = 7; i<=rownum; i++) {
					row = sheet.getRow(i);
					if(row !=null){
						String projectName = String.valueOf(getCellFormatValue(row.getCell(1))).trim();
						if(projectName!=null && !"".equals(projectName)){
							String[] dateday = new String[]{"2019-08-01"};
							String sql = "INSERT INTO `cyqytop20` (`project_name`, `this_period`,`same_period`,  `rise`, `dateday`, `static_type`) VALUES ('"
									+projectName+"', "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(2 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(3 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
									+String.valueOf(getCellFormatValue(row.getCell(4))).trim()+"','"
									+ dateday[0] + "','4')";
							System.out.println(sql);
							excuteSql(conn, sql);
						}

					}else{
						break;
					}
				}
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	//	8
	public static void readcstop20(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "8.2019年8月重点流通企业监测系统超市、便利店销售额前20强.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
				//获取第一个sheet
				sheet = wb.getSheetAt(0);
				//获取最大行数
				int rownum = sheet.getLastRowNum();
				for (int i = 7; i<=rownum; i++) {
					row = sheet.getRow(i);
					if(row !=null){
						String projectName = String.valueOf(getCellFormatValue(row.getCell(1))).trim();
						if(projectName!=null && !"".equals(projectName)){
							String[] dateday = new String[]{"2019-08-01"};
							String sql = "INSERT INTO `cstop20` (`project_name`, `this_period`,`same_period`,  `rise`, `dateday`, `static_type`) VALUES ('"
									+projectName+"', "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(2 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(3 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
									+String.valueOf(getCellFormatValue(row.getCell(4))).trim()+"','"
									+ dateday[0] + "','4')";
							System.out.println(sql);
							excuteSql(conn, sql);
						}

					}else{
						break;
					}
				}
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	//	9
	public static void readzmdtop20(String fileDir){
		Connection conn = getConnection();
		try{
			Workbook wb =null;
	        Sheet sheet = null;
	        Row row = null;
	        String filePath = fileDir + "9.2019年8月重点流通企业监测系统专业店及专卖店销售额前20强.xlsx";
	        wb = readExcel(filePath);
	        if(wb != null){
				//获取第一个sheet
				sheet = wb.getSheetAt(0);
				//获取最大行数
				int rownum = sheet.getLastRowNum();
				for (int i = 7; i<=rownum; i++) {
					row = sheet.getRow(i);
					if(row !=null){
						String projectName = String.valueOf(getCellFormatValue(row.getCell(1))).trim();
						if(projectName!=null && !"".equals(projectName)){
							String[] dateday = new String[]{"2019-08-01"};
							String sql = "INSERT INTO `zmdtop20` (`project_name`, `this_period`,`same_period`,  `rise`, `dateday`, `static_type`) VALUES ('"
									+projectName+"', "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(2 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", "
									+new BigDecimal(String.valueOf(getCellFormatValue(row.getCell(3 ))).trim()).setScale(5,BigDecimal.ROUND_HALF_UP)+", '"
									+String.valueOf(getCellFormatValue(row.getCell(4))).trim()+"','"
									+ dateday[0] + "','4')";
							System.out.println(sql);
							excuteSql(conn, sql);
						}

					}else{
						break;
					}
				}
	        }
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {
            	conn.close();
               
            } catch (Exception e1) {  
            }    
        }

	}

	
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    
    public static Object getCellFormatValue(Cell cell){
    	if(cell!=null){
	    	cell.setCellType(CellType.STRING);
	        Object cellValue = null;
	        if(cell!=null){
	            //判断cell类型
	            switch(cell.getCellType()){
					case NUMERIC:{
	                cellValue = String.valueOf(cell.getNumericCellValue());
	                break;
	            }
	            case FORMULA:{
	                //判断cell是否为日期格式
	                if(DateUtil.isCellDateFormatted(cell)){
	                    //转换为日期格式YYYY-mm-dd
	                    cellValue = cell.getDateCellValue();
	                }else{
	                    //数字
	                    cellValue = String.valueOf(cell.getNumericCellValue());
	                }
	                break;
	            }
					case STRING:{
						cellValue = cell.getRichStringCellValue().getString();
						break;
					}
	            default:
	                cellValue = "";
	            }
	        }else{
	            cellValue = "";
	        }
	        return cellValue;
    	}
    	return "";
    }

    public static Connection getConnection(){
		//String url="jdbc:mysql://172.28.50.187:3306/wjw?user=root&password=root";
		//String url="jdbc:mysql://172.31.68.150:3306/zyzx?user=root&password=root";
		//String url="jdbc:mysql://172.31.68.150:3306/bjtkk_jiami?user=root&password=root";
		//String url="jdbc:mysql://192.166.174.14:3306/jobs_db?user=root&password=syswin123";
		//String url="jdbc:mysql://192.166.174.11:3316/gaj?user=bjtoon&password=syswin@2016";
		String url="jdbc:mysql://172.31.68.204:3316/data_commerce?user=sjjh&password=sjjhsyswin";
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
    
    public static boolean excuteSql(Connection conn,String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }finally {  
            try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }
	}
}
