package com.example.gramswaraj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {"Image 1", "Image 2", "Image 3", "Image 4", "Image 5", "Image 6", "Image 7", "Image 8", "Image 9", "Image 10", "Image 11", "Image 12", "Image 13", "Image 14", "Image 15", "Image 16"};
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter (names,images,this);

        gridView.setAdapter(customAdapter);
        ImageView RightIcon=findViewById(R.id.right_icon);
        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(GalleryActivity.this,MainActivity.class);
                startActivity(i1);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = names[i];
                int selectedImage = images[i];
                startActivity(new Intent(GalleryActivity.this, clicked_item.class).putExtra("name", selectedName).putExtra("image", selectedImage));
            }
        });

    }

    public class CustomAdapter extends BaseAdapter{

        String[] imageNames;
        int[] imagesPhoto;
        Context context;
        LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context){
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount(){
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;

        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){

            if(view  == null){
                view = layoutInflater.inflate(R.layout.row_items, viewGroup, false);

            }

            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);

            tvName.setText(imageNames[i]);
            imageView.setImageResource(imagesPhoto[i]);

            return view;
        }
    }





}