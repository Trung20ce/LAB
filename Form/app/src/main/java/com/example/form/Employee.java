package com.example.form;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public long employId;
    @ColumnInfo(name = "employ_name")
    public String name;

    public String designation;

    public String email;

    public String adress;

}
