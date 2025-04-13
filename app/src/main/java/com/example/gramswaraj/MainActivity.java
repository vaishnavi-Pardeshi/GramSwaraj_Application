package com.example.gramswaraj;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtMarquee,txtMarquee1;
    Dialog dialogwin,dialogwin2 ;
    Button feed_button,contact_button;
    EditText et,win_mob,win_feedback;
    AutoCompleteTextView searchbar;
    String[] villages = {"Kandli","Village2","Village3"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SEARCHBAR
        searchbar = findViewById(R.id.search_bar);
        adapter = new ArrayAdapter<>(this
                ,android.R.layout.simple_dropdown_item_1line,villages);

        //Get suggestion
        searchbar.setThreshold(1);
        //set Adapter
        searchbar.setAdapter(adapter);

        searchbar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //go to the village activity
                Intent intent = new Intent(MainActivity.this, gpActivity.class);
                startActivity(intent);
            }
        });

        //Toolbar
        ImageView leftIcon=findViewById(R.id.left_icon);
        ImageView RightIcon=findViewById(R.id.right_icon);
        TextView title=findViewById(R.id.toolbar_title);
        TextView title2=findViewById(R.id.toolbar_title2);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        NavigationView navigationView=findViewById(R.id.navigation_view);

        //Slider
        ImageSlider imageSlider;
        imageSlider =findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.img5,null));
        imageList.add(new SlideModel(R.drawable.sl2,null));
        imageList.add(new SlideModel(R.drawable.sl1,null));


        imageSlider.setImageList(imageList);

        txtMarquee = (TextView) findViewById(R.id.marqueeText);
        txtMarquee.setSelected(true);
        txtMarquee1 = (TextView) findViewById(R.id.marqueeText1);
        txtMarquee1.setSelected(true);


        //Drawer
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You Clicked on logo!!",Toast.LENGTH_SHORT).show();
            }
        });
        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open_menu();
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_home:
                        Intent i1=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.about_us:
                        Intent i2=new Intent(MainActivity.this,aboutus_activity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(MainActivity.this, YojnaActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.gallery:
                        Intent i4=new Intent(MainActivity.this, GalleryActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.feedback:
                        open_feedback();
                        break;
                    case R.id.contact:
                        open_contact();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Hii", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

    public void open_feedback()
    {
        dialogwin=new Dialog(MainActivity.this);
        dialogwin.setContentView(R.layout.popup);
        dialogwin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogwin.show();
        //POPUP
        feed_button =(Button)dialogwin.findViewById(R.id.feed_button);
        et = (EditText)dialogwin.findViewById(R.id.win_name);
        win_mob=(EditText) dialogwin.findViewById(R.id.win_mob);
        win_feedback=(EditText) dialogwin.findViewById(R.id.win_feedback);
                //POPUP
                feed_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String  str=et.getText().toString();
                        String str2=win_mob.getText().toString();
                        String str3=win_feedback.getText().toString();
                        if(str.equalsIgnoreCase(""))
                        {
                            et.setHint("please enter your name");//it gives user to hint
                            et.setError("please enter your name");//it gives user to info message //use any one //
                        }
                        else
                        {
                            String name=et.getText().toString();
                            FirebaseDatabase.getInstance().getReference().child("hii").child("hello").setValue("abc");
                            Toast.makeText(MainActivity.this,name+" your Feedback has been submitted!!",Toast.LENGTH_LONG).show();
                            dialogwin.dismiss();
                        }
                    }
                });
    }
    public void open_contact()
    {
        //POPUP
        dialogwin2=new Dialog(this);
        dialogwin2.setContentView(R.layout.popup_contact);
        dialogwin2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogwin2.show();
        contact_button =(Button)dialogwin2.findViewById(R.id.contact_button);
        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogwin2.dismiss();
            }
        });
    }
}