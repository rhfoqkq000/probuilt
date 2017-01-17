package pro.pro.probuilt.pro;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import butterknife.BindView;
import pro.pro.probuilt.pro.fragment.ContactFragment;
import pro.pro.probuilt.pro.fragment.IntroFragment;
import pro.pro.probuilt.pro.fragment.ProductFragment;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    @BindView(R.id.toolbar_main) Toolbar toolbar;
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        bottomNavigation = (AHBottomNavigation)findViewById(R.id.bottom_id);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
    }

    private void createNavItems(){
        //Create item
        AHBottomNavigationItem menu = new AHBottomNavigationItem("ABOUT",R.drawable.menu);
        AHBottomNavigationItem on_off = new AHBottomNavigationItem("PRODUCT",R.drawable.box1);
        AHBottomNavigationItem mypage = new AHBottomNavigationItem("CONTACT",R.drawable.mypage);

        //Add Them to bar
        bottomNavigation.addItem(menu);
        bottomNavigation.addItem(on_off);
        bottomNavigation.addItem(mypage);

        //set properties
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#8c8c8c"));
        bottomNavigation.setInactiveColor(Color.parseColor("#ffffff"));
        bottomNavigation.setAccentColor(Color.parseColor("#3a417f"));


        //set current item
        bottomNavigation.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if(position==0){
            IntroFragment introFragment = new IntroFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, introFragment).commit();
        } else if (position == 1) {
            ProductFragment productFragment = new ProductFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, productFragment).commit();
        }else if(position==2){
            ContactFragment contactFragment = new ContactFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, contactFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0 <= intervalTime && FINSH_INTERVAL_TIME >= intervalTime){
            super.onBackPressed();
        }
        else{
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(),"'뒤로'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
