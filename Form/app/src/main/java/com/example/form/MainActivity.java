package com.example.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppDatabase mDb;
    private TextView txt_list;
    private Button button;
    private EditText etName;
    private EditText etDesignation;
    private EditText etEmail;
    private EditText etAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_list = (TextView) findViewById(R.id.txt_list);

        etName = (EditText) findViewById(R.id.etName);
        etDesignation = (EditText) findViewById(R.id.etDesignation);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAdress = (EditText) findViewById(R.id.etAdress);

        button = (Button) findViewById(R.id.button);
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
        populateEmployList();
        button.setOnClickListener(this);
    }

    private void populateEmployList() {
        txt_list.setText("");
        List<Employee> employeeList = mDb.employDao().findAllEmploySync();
        for (Employee employee : employeeList) {
            txt_list.append(employee.name + " : " + employee.designation + " : " + employee.email + " : " + employee.adress);
            txt_list.append("\n");
        }
    }

    @Override
    public void onClick(View view) {

        String name = etName.getText().toString().trim();
        String designation = etDesignation.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String adress = etAdress.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(designation)) {
            Toast.makeText(this, "Name/Designation should not be empty", Toast.LENGTH_SHORT).show();
        } else {
            Employee employee = new Employee();

            employee.name = name;
            employee.designation = designation;
            employee.email = email;
            employee.adress = adress;

            mDb.employDao().insertEmploy(employee);
            Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etDesignation.setText("");
            etEmail.setText("");
            etAdress.setText("");

            etName.requestFocus();
            populateEmployList();
        }
    }

}