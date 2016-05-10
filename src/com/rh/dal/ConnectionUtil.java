package com.rh.dal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
       
        public static String db_type	="";
        public static String DB_URL		="";
		public static String username	="";
		public static String password	="";
		final static Logger logger = Logger.getLogger(ConnectionUtil.class);
		static{
			try {
				
				Properties props = new Properties();
				props.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties"));
				DB_URL = props.getProperty("DB_URL");
				username = props.getProperty("USERNAME");
				password = props.getProperty("PASSWORD");
                db_type	 = props.getProperty("DB_TYPE");
            } catch (FileNotFoundException ex) {
            	logger.error("FileNotFoundException", ex);
            } catch (IOException e) {
            	logger.error("IOException", e);
            }
		}
        public static synchronized Connection getConnection()throws SQLException
        {
                Connection dbConnection = null;
                try
                {
                        if((db_type.toUpperCase()).equals("ORACLE"))
                        {
                                logger.info("connectiong with oracle");
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                dbConnection = DriverManager.getConnection(DB_URL,username,password);
                                dbConnection.setAutoCommit(true);
                                System.out.println("OracleConnectionUtil :: DB[Oracle] : Entered");
                        }
                        else if((db_type.toUpperCase()).equals("MYSQL"))
                        {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                logger.info("In ConnectionUtil.java: MYSQL Drivers LOADED ");
                                dbConnection =DriverManager.getConnection(DB_URL,username,password);
                                dbConnection.setAutoCommit(true);
                                logger.info("ConnectionUtil :: DB[ MYSQL ] : Entered");
                        }
                        else
                                System.out.println("Unkonown DataBase");
                }
                catch(Exception ex)
                {
                        System.out.println("ConnectionUtil :: Error in Reading File " + ex);
                        ex.printStackTrace();
                }
                return dbConnection;
        }
}
