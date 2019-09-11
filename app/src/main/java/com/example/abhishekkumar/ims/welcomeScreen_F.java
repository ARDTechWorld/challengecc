package com.example.abhishekkumar.ims;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;

public class welcomeScreen_F extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    TextView tv_Username;
    String pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen__f);
        tv_Username = (TextView) findViewById(R.id.tvUsername);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabview);


        tabLayout.setupWithViewPager(viewPager);
         Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        pic= extras.getString("propic");

//        new DownloadImageFromInternet((ImageView) findViewById(R.id.imgUser))
//                .execute("http://192.168.1.3/IMS/images/"+pic);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.imgUser))
                .execute("http://172.20.10.4/IMS/images/"+pic);

        tv_Username.setText("Welcome "+username);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Myinfo(), "My Info");
        adapter.AddFragment(new Studentinfo(), "Student Info");

        viewPager.setAdapter(adapter);

    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            //Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);
                //  imageView.setImageBitmap(bimage);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
