package com.masai.jiocinmea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.masai.jiocinmea.adapter.BannerMoviePagerAdapter;
import com.masai.jiocinmea.adapter.MainRecyclerAdapter;
import com.masai.jiocinmea.model.AllCategory;
import com.masai.jiocinmea.model.BannerMovies;
import com.masai.jiocinmea.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviePagerAdapter bannerMoviePagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager2;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> kidsBannerList;
    List<BannerMovies> videosBannerList;
    Timer sliderTimer;
   NestedScrollView nestedScrollView;
   AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecyclerView;
    List<AllCategory> allCategoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tabIndicator);
        categoryTab =findViewById(R.id.tabLayout);
        nestedScrollView =findViewById(R.id.nested_scroll);
        appBarLayout =findViewById(R.id.appbar);



        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Gaming Night","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        homeBannerList.add(new BannerMovies(3,"Hannah","https://images-na.ssl-images-amazon.com/images/M/MV5BNWJmMWIxMjQtZTk0Mi00YTE0LTkyNzAtYzQxYjcwYjE4ZDk2XkEyXkFqcGdeQXVyMTc4MzI2NQ@@._V1_SY500_SX350_AL_.jpg","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        homeBannerList.add(new BannerMovies(4,"Lodgers","https://images-na.ssl-images-amazon.com/images/M/MV5BM2FhM2E1MTktMDYwZi00ODA1LWI0YTYtN2NjZjM3ODFjYmU5XkEyXkFqcGdeQXVyMjY1ODQ3NTA@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        homeBannerList.add(new BannerMovies(5,"Chamber","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"));
        homeBannerList.add(new BannerMovies(6,"Survivor guide to Prison","https://images-na.ssl-images-amazon.com/images/M/MV5BNzhmNmI5MDMtZDEyOC00ODkyLTkwODItODQzODAzY2QyZjVlXkEyXkFqcGdeQXVyMzQwMTY2Nzk@._V1_SY500_CR0,0,357,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNzhmNmI5MDMtZDEyOC00ODkyLTkwODItODQzODAzY2QyZjVlXkEyXkFqcGdeQXVyMzQwMTY2Nzk@._V1_SY500_CR0,0,357,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(2,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(3,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(4,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        tvShowBannerList.add(new BannerMovies(5,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        movieBannerList.add(new BannerMovies(2,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        movieBannerList.add(new BannerMovies(3,"test","https://images-na.ssl-images-amazon.com/images/M/MV5BNTVlODgwMjgtZGUzMy00ZTY1LWIyMDEtYTI2Y2JlYzVjZTNkXkEyXkFqcGdeQXVyNTg0MDM1MzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"BigBuckBunny","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"));
        kidsBannerList.add(new BannerMovies(2,"Elephant Dream","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        kidsBannerList.add(new BannerMovies(3,"Bigger Blaze","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"));
        kidsBannerList.add(new BannerMovies(4,"Bigger Escapes","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"));
        kidsBannerList.add(new BannerMovies(5,"For Bigger Fun","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerFun.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        kidsBannerList.add(new BannerMovies(6,"For Bigger JoyRides","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerJoyrides.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"));

        videosBannerList = new ArrayList<>();
        videosBannerList.add(new BannerMovies(1,"For Bigger MeltDown","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerMeltdowns.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"));
        videosBannerList.add(new BannerMovies(1,"Sintel","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"));
        videosBannerList.add(new BannerMovies(1,"Subaru Outback On Street And Dirt","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        videosBannerList.add(new BannerMovies(1,"Tears of Steel","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"));
        videosBannerList.add(new BannerMovies(1,"Blender Foundation","https://images-na.ssl-images-amazon.com/images/M/MV5BOTY4NDcyZGQtYmVlNy00ODgwLTljYTMtYzQ2OTE3NDhjODMwXkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"));



        setBannerMoviePagerAdapter(homeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setScrollDefaultState();

                        setBannerMoviePagerAdapter(videosBannerList);

                            return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(tvShowBannerList);
                        return;
                    case 4:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(kidsBannerList);
                    default:
                        setScrollDefaultState();
                        setBannerMoviePagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //first we will add Cat_item data
        List<CategoryItem>  homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Leaning Into the Wind: Andy Goldsworthy","https://images-na.ssl-images-amazon.com/images/M/MV5BYWRjMTZhN2ItZDE1MC00NWQyLThkZTUtMTRjMGZhODE0NTQxXkEyXkFqcGdeQXVyMjA1NzQwNjM@._V1_SY190_SX318_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(2,"Tom Raider","https://images-na.ssl-images-amazon.com/images/M/MV5BOTY4NDcyZGQtYmVlNy00ODgwLTljYTMtYzQ2OTE3NDhjODMwXkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(3,"Love Simon","https://images-na.ssl-images-amazon.com/images/M/MV5BZTVkOWJkOTYtM2FlZS00YTBlLWE2YTYtODEyZWJjMTZkM2IzXkEyXkFqcGdeQXVyMTQ4NzkzOTA@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(4,"Kidnapper","https://images-na.ssl-images-amazon.com/images/M/MV5BMjAwNDMzNzg0Nl5BMl5BanBnXkFtZTgwOTkxNjY2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        homeCatListItem1.add(new CategoryItem(5,"Flower","https://images-na.ssl-images-amazon.com/images/M/MV5BYzViOTBmMGUtODBlMi00YzYzLThiM2MtOGFlMzZkNWU4NDRjXkEyXkFqcGdeQXVyODE0MDY3NzY@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));

        List<CategoryItem> homeCatListItem2 =new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Fear","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        homeCatListItem2.add(new CategoryItem(2,"Dark","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        homeCatListItem2.add(new CategoryItem(3,"Life and Risk","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        homeCatListItem2.add(new CategoryItem(4,"Hannah Montanah","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        homeCatListItem2.add(new CategoryItem(5,"Fear fires","https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_SY1000_CR0,0,674,1000_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        homeCatListItem2.add(new CategoryItem(6,"Dark Moon","https://images-na.ssl-images-amazon.com/images/M/MV5BZTVkOWJkOTYtM2FlZS00YTBlLWE2YTYtODEyZWJjMTZkM2IzXkEyXkFqcGdeQXVyMTQ4NzkzOTA@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));

        List<CategoryItem> homeCatListItem3 =new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"Light","https://images-na.ssl-images-amazon.com/images/M/MV5BYWRjMTZhN2ItZDE1MC00NWQyLThkZTUtMTRjMGZhODE0NTQxXkEyXkFqcGdeQXVyMjA1NzQwNjM@._V1_SY190_SX318_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        homeCatListItem3.add(new CategoryItem(2,"Saas Bahu or Saajish","https://images-na.ssl-images-amazon.com/images/M/MV5BMTg1NTg2MzcyNF5BMl5BanBnXkFtZTgwNjMwMDIzNDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        homeCatListItem3.add(new CategoryItem(3,"Raj","https://images-na.ssl-images-amazon.com/images/M/MV5BMTk4MzQ1NDY2OF5BMl5BanBnXkFtZTgwNjA4Nzc4MzI@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        homeCatListItem3.add(new CategoryItem(4,"Risk","https://images-na.ssl-images-amazon.com/images/M/MV5BMjAyMTk2MTQ3Ml5BMl5BanBnXkFtZTgwNDQ2ODE0NDM@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        homeCatListItem3.add(new CategoryItem(5,"Race","https://images-na.ssl-images-amazon.com/images/M/MV5BMzg3Y2MyNjgtMzk4ZS00OTU3LWEwZmMtN2Y0NTdlZjU0NGFiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY500_CR0,0,337,500_AL_.jpg","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next TV and movies",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Kids and family movies",homeCatListItem3));
        //set recycler Method
        setMainRecyclerView(allCategoryList);
    }
    private  void setBannerMoviePagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager2 =findViewById(R.id.banner_Viewpager);
        bannerMoviePagerAdapter = new BannerMoviePagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager2.setAdapter(bannerMoviePagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager2);

        Timer sliderTimer  = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlide(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager2,true);



    }
    class AutoSlide extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(() -> {
                if (bannerMoviesViewPager2.getCurrentItem() < homeBannerList.size() - 1) {
                    bannerMoviesViewPager2.setCurrentItem(bannerMoviesViewPager2.getCurrentItem() + 1);

                } else {
                    bannerMoviesViewPager2.setCurrentItem(0);

                }

            });
        }
    }
    public  void setMainRecyclerView(List<AllCategory> allCategoryList){
        mainRecyclerView =findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter =  new MainRecyclerAdapter(this,allCategoryList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);
    }
    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}