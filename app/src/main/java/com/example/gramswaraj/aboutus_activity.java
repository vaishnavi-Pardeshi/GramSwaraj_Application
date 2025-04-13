package com.example.gramswaraj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class aboutus_activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus2);

        NavigationView navigationView=findViewById(R.id.navigation_view);
        ImageView RightIcon=findViewById(R.id.right_icon);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);

        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        Intent i1=new Intent(aboutus_activity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.about_us:
                        Intent i2=new Intent(aboutus_activity.this,aboutus_activity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(aboutus_activity.this,YojnaActivity.class);
                        startActivity(i3);
                        break;
                    default:
                        Toast.makeText(aboutus_activity.this, "Hii", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

    public void open_menu()
    {
        Intent i1=new Intent(this,MainActivity2.class);
        startActivity(i1);
    }

}