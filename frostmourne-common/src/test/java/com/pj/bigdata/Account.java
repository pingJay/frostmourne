package com.pj.bigdata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by pingjie on 15-11-23.
 */
@DatabaseTable(tableName = "account")
public class Account {
    @DatabaseField(generatedId = true)
    private  int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String passwd;

    public Account() {
    }

    public Account(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
