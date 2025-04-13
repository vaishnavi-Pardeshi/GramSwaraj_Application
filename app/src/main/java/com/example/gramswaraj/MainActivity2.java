package com.example.gramswaraj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {
    Dialog dialogwin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView leftIcon=findViewById(R.id.left_icon);
        ImageView RightIcon=findViewById(R.id.right_icon);
        TextView title=findViewById(R.id.toolbar_title);
        ListView list_view = (ListView) findViewById(R.id.list);

        String values[]= {"मुख्यपृष्ठ","आमच्याविषयी","योजना","फॉर्म","गॅलरी","अभिप्राय","लॉगिन","संपर्क"};

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arrays.asList(values));

        list_view.setAdapter(arrayAdapter);

        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_menu();
            }
        });

        list_view.setAdapter(arrayAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(values[position]=="आमच्याविषयी")
                {
                    open_aboutus();
                }
                if(values[position]=="मुख्यपृष्ठ")
                {
                    open_menu();
                }
                if(values[position]=="गॅलरी")
                {
                    open_gallery();
                }
                /*if(values[position]=="लॉगिन")
                {
                    open_login();
                }*/
                if(values[position]=="अभिप्राय")
                {
                    open_feedback();
                }
                if(values[position]=="संपर्क")
                {
                    open_contact();
                }
                if(values[position]=="योजना")
                {
                    open_yojna();
                }
            }
        });
    }

    public void open_menu()
    {
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);
    }
    public void open_aboutus()
    {
        Intent i2=new Intent(this,aboutus_activity.class);
        startActivity(i2);
    }
    public void open_gallery()
    {
        Intent i3=new Intent(this,GalleryActivity.class);
        startActivity(i3);
    }
    /*public void open_login()
    {
        Intent i4=new Intent(this,LoginActivity.class);
        startActivity(i4);
    }*/
    public void open_feedback()
    {

            dialogwin=new Dialog(this);
            dialogwin.setContentView(R.layout.popup);
            dialogwin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialogwin.show();
    }

    public void open_contact()
    {
        dialogwin=new Dialog(this);
        dialogwin.setContentView(R.layout.popup_contact);
        dialogwin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogwin.show();
    }
    public void open_yojna()
    {
        Intent i5=new Intent(this,YojnaActivity.class);
        startActivity(i5);
    }

}