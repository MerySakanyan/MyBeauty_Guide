package am.mydrugbox.mery.beauty_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Name> arrayList;
   private Adapter adapter;
   private  DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        recyclerView=findViewById(R.id.recyclerView);


        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);

        arrayList = new ArrayList<>();

 //       arrayList.add(new Name("Dr. Dana Beauty Consultant",R.drawable.a));
        arrayList.add(new Name("Aga Kankanyan Image Studio", R.drawable.aga));
        arrayList.add(new Name("Anka Beauty Salon", R.drawable.anka));
         //     arrayList.add(new Name("Beauty by Julhakyans",R.drawable.julhakyan));
    //    arrayList.add(new Name("Estet Beauty Salon",R.drawable.estet));
        arrayList.add(new Name("Haze",R.drawable.haze));
     //   arrayList.add(new Name("Hermina Beauty Salon",R.drawable.hermina));
        arrayList.add(new Name("Hermitage Beauty House",R.drawable.hermitage));
       // arrayList.add(new Name("Ilona VIP Spa & Beauty Centre",R.drawable.ilona));
     //   arrayList.add(new Name("LUSE",R.drawable.luse));
       // arrayList.add(new Name("Make-up Studio",R.drawable.makeup));
      //  arrayList.add(new Name("Manya Beauty Salon",R.drawable.manya));
     //   arrayList.add(new Name("Maria Beauty Lounge",R.drawable.maria));
        arrayList.add(new Name("Mona Beauty Salon", R.drawable.mona));
       // arrayList.add(new Name("NE Beauty Salon", R.drawable.ne));
      //  arrayList.add(new Name("OD Blow Dry Bar",R.drawable.od));
       // arrayList.add(new Name("Pavone Beauty Salon & Beauty Store",R.drawable.pavone));
     //   arrayList.add(new Name("Sidni Beauty Salon3",R.drawable.sidni));
       // arrayList.add(new Name("SOLO Beauty Salon",R.drawable.a18));
        adapter= new Adapter(arrayList, this);
        recyclerView.setAdapter(adapter);



       drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView facebook=findViewById(R.id.facrbook),
                twitter=findViewById(R.id.twitter),
                linledin=findViewById(R.id.linkedin),
                gooleplus=findViewById(R.id.googleplus);
facebook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://web.facebook.com/basic.it.center/"));
        startActivity(intent);
    }
});
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/basicitcenter"));
                startActivity(intent);
            }
        });
        gooleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://accounts.google.com/AccountChooser?service=lbc&continue=https://business.google.com/dashboard/l/02609645022590899463?hl%3Den%26acct_rdr%3D1&hl=en"));
                startActivity(intent);
            }
        });
        linledin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/basic-it-center/"));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2,menu);
        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
              int id = item.getItemId();
switch (id){
    case R.id.about:
        Intent intent=new Intent(Main2Activity.this, AboutUs.class);
        startActivity(intent);
}


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Name> newlist=new ArrayList<>();
        for(Name nname :arrayList){
            String name=nname.getName().toLowerCase();
            if (name.contains(newText)){
                newlist.add(nname);
            }
        }
        adapter.setFilter(newlist);
        return true;
    }
}
