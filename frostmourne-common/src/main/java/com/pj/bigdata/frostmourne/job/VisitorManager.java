package com.pj.bigdata.frostmourne.job;

import com.pj.bigdata.frostmourne.database.FrostmourneDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by pingjie on 15-11-20.
 */
public class VisitorManager {
    private static FrostmourneDataSource dataSource = FrostmourneDataSource.getInstance();


    public void insertVisitor() throws SQLException {
        Connection connection = dataSource.getconnection();
        String sql = "insert into visitor (name,status,createtime) values (?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        try {
            int i = queryRunner.update(connection,sql,"pingjie",1,new Date());
            BigInteger bi = queryRunner.query(connection,"select last_insert_id()",new ScalarHandler<BigInteger>(1));
            System.out.println(bi);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    public Visitor findById(int id) {
        Connection connection = dataSource.getconnection();
        String sql = "select * from visitor where id=?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Visitor visitor = queryRunner.query(connection, sql, new BeanHandler<Visitor>(Visitor.class), id);
            return visitor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        VisitorManager visitorManager = new VisitorManager();
        System.out.println(visitorManager.findById(1).toString());
    }
}
