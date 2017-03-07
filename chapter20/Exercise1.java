/**
 *  注解处理器
 *  利用注解，从java类中直接生成SQL语句，创建Table。
 */
package com.ciaoshen.thinkinjava.chapter20;
import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import com.ciaoshen.thinkinjava.chapter20.db.*;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for(String className : args) {
            Class<?> cl = Class.forName(className);
            
            /**
             *  Table Name
             */
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if(dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if(tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            
            /**
             *  SQL
             */
            List<String> columnDefs = new ArrayList<String>();
            for(Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length < 1){
                    continue; // Not a db table column
                }
                if(anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Use field name if name not specified
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if(anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // Use field name if name not specified.
                    if(sString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
                if(anns[0] instanceof SQLDecimal) {
                    SQLDecimal sd = (SQLDecimal) anns[0];
                    // Use field name if name not specified.
                    if(sd.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sd.name();
                    }
                    columnDefs.add(columnName + " DECIMAL(" + sd.value() + ")" + getConstraints(sd.constraints()));
                }
                if(anns[0] instanceof SQLDate) {
                    SQLDate sd = (SQLDate) anns[0];
                    // Use field name if name not specified.
                    if(sd.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sd.name();
                    }
                    columnDefs.add(columnName + " DATE(" + sd.value() + ")" + getConstraints(sd.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for(String columnDef : columnDefs){
                    createCommand.append("\n " + columnDef + ",");
                }
                // Remove trailing comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }
    private static String getConstraints(Constraints con) {
        String constraints = "";
        if(!con.allowNull()){
            constraints += " NOT NULL";
        }
        if(con.primaryKey()){
            constraints += " PRIMARY KEY";
        }
        if(con.unique()){
            constraints += " UNIQUE";
        }
        return constraints;
    }
}