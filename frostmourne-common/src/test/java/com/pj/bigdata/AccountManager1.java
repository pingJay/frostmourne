package com.pj.bigdata;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.MysqlDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pj.bigdata.frostmourne.database.FrostmourneDataSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pingjie on 15-11-23.
 */
public class AccountManager1 {

    public void test2(int i) {
        try {
            this.test1(i);
        } catch (AccountManagerExecption accountManagerExecption) {
            throw new RuntimeException("dwaffesffge55fe",accountManagerExecption);
        }
        System.out.println("222222222222222");
    }

    public void test3(int i) throws AccountManagerExecption {
        this.test1(i);
    }

    public int test1(int i) throws AccountManagerExecption {
        if (i > 10) {
            return i;
        }else {
            throw new AccountManagerExecption("i less 10");
        }
    }
    public static void main(String[] args) throws AccountManagerExecption {
        AccountManager1 accountManager1 = new AccountManager1();
        accountManager1.test2(9);
    }
}
