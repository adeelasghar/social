///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mentoringminds.haris.social.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.naming.NamingException;
// 
//public class JdbcSQLServerConnection {
// 
//    
//    
//    
// 
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//	    public static  Connection getCon(){
//	 try{
//	         javax.naming.InitialContext ctx = new javax.naming.InitialContext();
//  javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("jdbc/SQLServer2");
//  java.sql.Connection conn = ds.getConnection();
//  return conn;
//	    }catch(SQLException | NamingException e){System.out.println(e); return null;}
//	    
//        
//}
//}