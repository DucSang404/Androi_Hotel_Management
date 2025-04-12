package com.example.das_hotel.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.das_hotel.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        HorizontalScrollView domesticView = findViewById(R.id.domesticView);
        HorizontalScrollView internationalView = findViewById(R.id.internationalView);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    domesticView.setVisibility(View.VISIBLE);
                    internationalView.setVisibility(View.GONE);
                } else {
                    domesticView.setVisibility(View.GONE);
                    internationalView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        loadTab(tabLayout);
        loadDomesticCard();
        loadInternationCard();

    }

    private void loadTab(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("Trong nước"));

        TabLayout.Tab tabQuocTe = tabLayout.newTab().setText("Quốc tế");
        tabLayout.addTab(tabQuocTe);

        tabLayout.post(() -> {
            View tabView = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(tabLayout.getTabCount() - 1);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
            params.leftMargin = 20;
            tabView.setLayoutParams(params);
        });
    }

    private void loadDomesticCard() {
        int[] cardIds = { R.id.cardHCM, R.id.cardHN, R.id.cardDN, R.id.cardDL };
        int[] imageRes = { R.drawable.hcm, R.drawable.hn, R.drawable.danang, R.drawable.dalat };
        String[] locationNames = { "Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Đà Lạt" };

        for (int i = 0; i < cardIds.length; i++) {
            CardView card = findViewById(cardIds[i]);
            ImageView imageView = card.findViewById(R.id.imageLocation);
            TextView textView = card.findViewById(R.id.locationName);

            imageView.setImageResource(imageRes[i]);
            textView.setText(locationNames[i]);
        }
    }

    private void loadInternationCard() {
        int[] cardIds = { R.id.cardFrance, R.id.cardSingapore, R.id.cardKorea, R.id.cardJapan, R.id.cardUK };
        int[] imageRes = { R.drawable.france, R.drawable.singapore, R.drawable.korea, R.drawable.japan, R.drawable.uk };
        String[] locationNames = { "Pháp", "Singapore", "Hàn Quốc", "Nhật Bản", "Anh" };

        for (int i = 0; i < cardIds.length; i++) {
            CardView card = findViewById(cardIds[i]);
            ImageView imageView = card.findViewById(R.id.imageLocation);
            TextView textView = card.findViewById(R.id.locationName);

            imageView.setImageResource(imageRes[i]);
            textView.setText(locationNames[i]);
        }
    }
}
