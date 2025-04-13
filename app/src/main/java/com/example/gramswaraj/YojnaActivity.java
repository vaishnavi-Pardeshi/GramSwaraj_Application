package com.example.gramswaraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class YojnaActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] yojna = { "प्रधानमंत्री किसान सम्मान निधि योजना", "प्रधान मंत्री कृषि सिंचाई योजना (पीएमकेएसवाई)", "ग्रामीण भंडारण योजना", "राष्ट्रीय पशुधन मिशन (एनएलएम)", "राष्ट्रीय गोकुल मिशन (आरजीएम)", "पशुधन किसानों को किसान क्रेडिट कार्ड (केसीसी)","पशुपालन अवसंरचना विकास निधि","राष्ट्रीय पशु रोग नियंत्रण कार्यक्रम"};
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yojna);

        mListView = (ListView) findViewById(R.id.userlist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, yojna);
        mListView.setAdapter(aAdapter);

        ImageView RightIcon=findViewById(R.id.right_icon);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);

        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open_menu();
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(yojna[position]=="प्रधानमंत्री किसान सम्मान निधि योजना") {
                    open_web1("https://pmkisan.gov.in/");
                }
                if(yojna[position]=="प्रधान मंत्री कृषि सिंचाई योजना (पीएमकेएसवाई)") {
                    open_web1("https://pmksy.gov.in/");
                }
                if(yojna[position]=="ग्रामीण भंडारण योजना") {
                    open_web1("https://www.nabard.org/hindi/content1.aspx?id=593&catid=23&mid=530");
                }
                if(yojna[position]=="राष्ट्रीय पशुधन मिशन (एनएलएम)") {
                    open_web1("https://dahd.nic.in/hi/national_livestock_mission");
                }
                if(yojna[position]=="राष्ट्रीय गोकुल मिशन (आरजीएम)") {
                    open_web1("https://dahd.nic.in/hi/rgm");
                }
                if(yojna[position]=="पशुधन किसानों को किसान क्रेडिट कार्ड (केसीसी)") {
                    open_web1("https://dahd.nic.in/hi/kcc");
                }
                if(yojna[position]=="पशुपालन अवसंरचना विकास निधि") {
                    open_web1("https://dahd.nic.in/hi/ahidf");
                }
                if(yojna[position]=="राष्ट्रीय पशु रोग नियंत्रण कार्यक्रम") {
                    open_web1("https://dahd.nic.in/hi");
                }
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
                        Intent i1=new Intent(YojnaActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.about_us:
                        Intent i2=new Intent(YojnaActivity.this,aboutus_activity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(YojnaActivity.this,YojnaActivity.class);
                        startActivity(i3);
                        break;
                    default:
                        Toast.makeText(YojnaActivity.this, "Hii", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

    public void open_web1(String url){
            setContentView(R.layout.activity_webview);
            WebView webView = (WebView) findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
    }


}
