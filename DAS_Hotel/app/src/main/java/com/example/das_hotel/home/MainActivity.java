package com.example.das_hotel.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.das_hotel.login.LoginActivity;
import com.example.das_hotel.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPagerSlider;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton menuButton;
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int nextItem = viewPagerSlider.getCurrentItem() + 1;
            if(nextItem >= imageArray.length) {
                nextItem = 0;
            }
            viewPagerSlider.setCurrentItem(nextItem, true);
            sliderHandler.postDelayed(this, 3000);
        }

    };
    private int[] imageArray = {R.drawable.pic_home1, R.drawable.pic_home2, R.drawable.pic_home3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Image slide
        viewPagerSlider = findViewById(R.id.viewPagerSlider);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, imageArray);
        viewPagerSlider.setAdapter(adapter);

        // Navigation
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.design_navigation_view);
        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Xử lý cho Home
                } else if (id == R.id.nav_search_by_category) {
                    // Xử lý cho Search Room by Category
                }
                else if (id == R.id.nav_rooms) {
                    // Xử lý cho Search Room by Category
                }
                else if (id == R.id.nav_register) {
                    // Xử lý cho Search Room by Category
                }
                else if (id == R.id.nav_login) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_about_us) {
                    // Xử lý cho Search Room by Category
                }
                else if (id == R.id.nav_contact_us) {
                    // Xử lý cho Search Room by Category
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        // Card click
        CardView cardLogin = findViewById(R.id.card_login);

        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}
