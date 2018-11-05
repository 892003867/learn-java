package _07_DBCP;

import org.apache.commons.dbcp2.BasicDataSource;
import utils.DBCPUtils;

import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws Exception {
        BasicDataSource bds =   DBCPUtils.getClassReflect();
        System.out.println(bds);
    }
}
