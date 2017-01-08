package com.storesales.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConn {

	public static void main(String[] args) {
		new TestConn().printLingxing(9);
		
	}
	public void printLingxing(int num){
		if(num%2==0||num<3){
			System.out.print("invild param");
			return;
		}
		printLing(9);
	}
	
	public void printLing(int rownum){
		int rowmiddle = rownum/2;
		int spaceLength = rowmiddle;
		StringBuilder fullspace=new StringBuilder();
		StringBuilder stars = new StringBuilder("*");
		for(int i=0;i<spaceLength;i++){
			fullspace.append(" ");
		}
		for(int i=0;i<rowmiddle;i++){
			String line = fullspace.substring(0, rowmiddle-i)+stars.toString();
			System.out.println(line);
			stars.append("**");
		}
		for(int i=rowmiddle;i<rownum;i++){
			String line = fullspace.substring(0, i-rowmiddle)+stars.toString();
			System.out.println(line);
			stars.delete(0, 2);
		}
	}
	
	
	public void testconn(){
		try{
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();   
			   String url = "jdbc:microsoft:sqlserver://localhost:1053;DatabaseName=pos";//数据库名需要自定义  
			   String user="sa"; //用户需要自定义  
			   String password=""; //密码需要自定义  
			   Connection conn= DriverManager.getConnection(url,user,password);  
			   Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);     
			   String sql="select * from bi_t_branch_info";//SQL查询语句需要自定义  
			   ResultSet rs=stmt.executeQuery(sql);     
			   while(rs.next()) {     
			    System.out.println("您的第一个字段内容为："+rs.getString(1));  
			    System.out.println("您的第二个字段内容为："+rs.getString(2));  
			   }   
			   System.out.print("数据库操作成功，恭喜你");     
			   rs.close();     
			   stmt.close();     
			   conn.close();    
			   
			}catch(Exception e){
				e.printStackTrace();
			}
	}

}
