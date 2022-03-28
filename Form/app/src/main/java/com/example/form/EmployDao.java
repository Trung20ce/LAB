package com.example.form;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployDao {

    @Insert(onConflict = REPLACE)
    void insertEmploy(Employee employee);

    @Insert(onConflict = IGNORE)
    void insertOrReplaceEmploy(Employee... employees);

    @Update(onConflict = REPLACE)
    void updateEmploy(Employee employee);

    @Query("DELETE FROM Employee")
    void deleteAll();

    @Query("SELECT * FROM Employee")
    public List<Employee> findAllEmploySync();
}
