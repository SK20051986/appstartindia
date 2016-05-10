package com.rh.utility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.rh.dal.ConnectionUtil;
public class Util
{
	 public static int ExecuteQuery(String Query)
     {
             Statement  selectStmt           = null;
             Connection activeConnection     = null;
             ResultSet DetailsResultSet      = null;
             int Result = 0;
             try
             {
                     activeConnection  = ConnectionUtil.getConnection();
             }
             catch(Exception od)
             {
                     System.out.println("[ETT] []In index.java:   Not able to connect with MYSQL");
                     od.printStackTrace();
             }
             try
             {
                     selectStmt = activeConnection.createStatement();
                      DetailsResultSet = selectStmt.executeQuery(Query);
                     while(DetailsResultSet.next())
                     {
                             Result=DetailsResultSet.getInt(1);
                     }
                     DetailsResultSet.close();
                     selectStmt.close();
                     activeConnection.close();
                     System.out.println("query["+Query+"] has been executed...!!!"+Result);
             }
             catch(SQLException ESQL)
             {
                     System.out.println("[ETT] [] In index.java:    SQL Error" + ESQL.getMessage());
             }
             finally
             {
                     try
                     {
                             selectStmt.close();
                             activeConnection.close();
                     }
                     catch(Exception ee)
                     {
                             System.out.println("[ETT] []In index.java:    Exception: " +ee.getMessage());
                             ee.printStackTrace();
                                             }
             }
             return Result;
     }

        public static String getMsisdn(String ett,String flag)
        {
                String SelectQuery = "";
                Statement selectStmt            = null;
                Connection activeConnection     = null;
                ResultSet DetailsResultSet      = null;
                int size                        = -1;
                String result                   = "";
                if(flag.equals("ett"))
                {
                        SelectQuery="SELECT msisdn from User where ettId='"+ett+"'";
                }
                else
                {
                        SelectQuery="SELECT ettId from User where msisdn='"+ett+"'";
                }
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Query to be run is "+SelectQuery);
                try
                {
                        activeConnection  = ConnectionUtil.getConnection();
                }
                catch(Exception od)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:   Not able to connect with ORACLE");
                        od.printStackTrace();
                }
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    ORA Connection Created!");
                try
                {
                        selectStmt = activeConnection.createStatement();
                        DetailsResultSet = selectStmt.executeQuery(SelectQuery);
                        while(DetailsResultSet.next())
                        {
                                result=DetailsResultSet.getString(1);

                        }
                        DetailsResultSet.close();
                        selectStmt.close();
                        activeConnection.close();
                }
                catch(SQLException ESQL)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    SQL Error" + ESQL.getMessage());
                }
                finally
                {
                        try
                        {
                                DetailsResultSet.close();
                                selectStmt.close();
                                activeConnection.close();
                        }
                        catch(Exception ee)
                        {
                                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Exception: " +ee.getMessage());
                                ee.printStackTrace();
                        }
                }
                return result;
        }
        public static String getOffer(String SelectQuery)
        {
                
                Statement selectStmt            = null;
                Connection activeConnection     = null;
                ResultSet DetailsResultSet      = null;
                int size                        = -1;
                String result                   = "";
                

                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Query to be run is "+SelectQuery);
                try
                {
                        activeConnection  = ConnectionUtil.getConnection();
                }
                catch(Exception od)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:   Not able to connect with ORACLE");
                        od.printStackTrace();
                }
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    ORA Connection Created!");
                try
                {
                        selectStmt = activeConnection.createStatement();
                        DetailsResultSet = selectStmt.executeQuery(SelectQuery);
                        while(DetailsResultSet.next())
                        {
                                result=DetailsResultSet.getString(1)+","+DetailsResultSet.getString(2);

                        }

                        DetailsResultSet.close();
                                                selectStmt.close();
                        activeConnection.close();
                }
                catch(SQLException ESQL)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    SQL Error" + ESQL.getMessage());
                }
                finally
                {
                        try
                        {
                                DetailsResultSet.close();
                                selectStmt.close();
                                activeConnection.close();
                        }
                        catch(Exception ee)
                        {
                                System.out.println("[ETT] ["+GetDate()+"]"+"In Util.java:    Exception: " +ee.getMessage());
                                ee.printStackTrace();
                        }
                }
                return result;
        }
        public static String checkElegibility(String ett,String flag)
        {
                String SelectQuery = "";
                Statement selectStmt            = null;
                Connection activeConnection     = null;
                ResultSet DetailsResultSet      = null;
                int size                        = -1;
                String result                   = "";
                if(flag.equals("Install"))
                {
                        SelectQuery="SELECT appKey from InstalledApps where ettId='"+ett+"'";
                }
                else{
                        SelectQuery="SELECT appKey from UnInstalledApps where ettId='"+ett+"'";
                }

                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Query to be run is "+SelectQuery);
                try
                {
                        activeConnection  = ConnectionUtil.getConnection();
                }
                catch(Exception od)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:   Not able to connect with ORACLE");
                        od.printStackTrace();
                }
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    ORA Connection Created!");
                try
                {
                        selectStmt = activeConnection.createStatement();
                        DetailsResultSet = selectStmt.executeQuery(SelectQuery);
                        while(DetailsResultSet.next())
                        {
                                result=DetailsResultSet.getString(1);

                        }

                        DetailsResultSet.close();
                                                selectStmt.close();
                        activeConnection.close();
                }
                catch(SQLException ESQL)
                {
                        System.out.println("[ETT] ["+GetDate()+"]"+"In Util.java:    SQL Error" + ESQL.getMessage());
                }
                finally
                {
                        try
                        {
                                DetailsResultSet.close();
                                selectStmt.close();
                                activeConnection.close();
                        }
                        catch(Exception ee)
                        {
                                System.out.println("[ETT] ["+GetDate()+"]"+"In Util.java:    Exception: " +ee.getMessage());
                                ee.printStackTrace();
                        }
                }
                return result;
        }
        public static String getOfferText(String offer_id)
        {
                String SelectQuery = "";
                Statement selectStmt            = null;
                Connection activeConnection     = null;
                ResultSet DetailsResultSet      = null;
                int size                        = -1;
                String result                   = "";
                SelectQuery="SELECT recommendtext from recommend_offer where offer_id='"+offer_id+"'";
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Query to be run is "+SelectQuery);
                try
                {
                        activeConnection  = ConnectionUtil.getConnection();
                }
                catch(Exception od)
                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:   Not able to connect with ORACLE");
                        od.printStackTrace();
                }
                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    ORA Connection Created!");
                try
                {
                        selectStmt = activeConnection.createStatement();
                        DetailsResultSet = selectStmt.executeQuery(SelectQuery);
                        while(DetailsResultSet.next())
                        {
                                result=DetailsResultSet.getString(1);

                        }

                        DetailsResultSet.close();
                                                selectStmt.close();
                        activeConnection.close();
                }
                catch(SQLException ESQL)
                                {
                        System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    SQL Error" + ESQL.getMessage());
                }
                finally
                {
                        try
                        {
                                DetailsResultSet.close();
                                selectStmt.close();
                                activeConnection.close();
                        }
                        catch(Exception ee)
                        {
                                System.out.println("[Recommended] [ETT] ["+GetDate()+"]"+"In Util.java:    Exception: " +ee.getMessage());
                                ee.printStackTrace();
                        }
                }
                return result;
        }

        public static String GetDate()
        {
                Calendar cal = Calendar.getInstance();
                String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
                return sdf.format(cal.getTime());
        }
}
