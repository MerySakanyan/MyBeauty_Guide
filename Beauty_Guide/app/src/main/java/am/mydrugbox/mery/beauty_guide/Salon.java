package am.mydrugbox.mery.beauty_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Salon extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;
    //dzer nkarner@ estex avelacreq
    private int[] myImageListhaze = new int[]{R.drawable.haze,R.drawable.haze,R.drawable.haze};
    private int[] myImageListaga = new int[]{R.drawable.aga,R.drawable.haze,R.drawable.aga};
    private int[] myImageListanka = new int[]{R.drawable.anka,R.drawable.anka,R.drawable.anka};
    private int[] myImageListhemitaje = new int[]{R.drawable.hermitage,R.drawable.hermitage,R.drawable.hermitage};
    private int[] myImageListmona = new int[]{R.drawable.mona,R.drawable.mona,R.drawable.mona};
private TextView adress, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbartext=findViewById(R.id.toolbartext),
                salonname=findViewById(R.id.salonname);

                about=findViewById(R.id.about);
        adress=findViewById(R.id.adress);
        RelativeLayout relativeLayout=findViewById(R.id.relativeLayout);

        String name=getIntent().getExtras().getString("name");
        toolbartext.setText(name);
        salonname.setText(name);

        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width=metrics.widthPixels,
                height=(width*2)/3;
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(width, height);
        relativeLayout.setLayoutParams(params);
        ImageButton backbutton=findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Salon.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });

LinearLayout layout=findViewById(R.id.map);
layout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    switch (adress.getText().toString()){
        case "14 Isahakyan St., Yerevan, Armenia":
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://goo.gl/maps/QJTdVfw3JdL2"));
            startActivity(intent);
        break;
    }

    }
});
        imageModelArrayList = new ArrayList<>();
        switch (name){
            case "Aga Kankanyan Image Studio":
                imageModelArrayList = populateList(myImageListaga,"14 Isahakyan St., Yerevan, Armenia");
                break;
            case "Anka Beauty Salon":
                imageModelArrayList = populateList(myImageListanka,"");
                break;
            case "Haze":
                imageModelArrayList = populateList(myImageListhaze,"");
                break;
            case "Hermitage Beauty House":
                imageModelArrayList = populateList(myImageListhemitaje,"");
                break;
            case "Mona Beauty Salon":
                imageModelArrayList = populateList(myImageListmona,"");
                break;
        }


        init();
    }
    private ArrayList<ImageModel> populateList(int imagelist[],String ad){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage(imagelist[i]);
            list.add(imageModel);
        }
        adress.setText(ad);
        return list;
    }

    private void init() {

        mPager =  findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(Salon.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//aystex kpoxeq shrjanneri sharavixner@
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        //avtomat ashxatanqn e sksvum
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);


        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
