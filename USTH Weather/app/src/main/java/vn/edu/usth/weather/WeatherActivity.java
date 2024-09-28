package vn.edu.usth.weather;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("Weather Activity", "Creating an App !");

        // Set up the ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize the adapter and the ViewPage
        ViewPager2 viewPager2 = findViewById(R.id.pager);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(this);

        // Set up the Adapter
        viewPager2.setAdapter(adapter);

        // Set up the TabLayout
        TabLayout tabLayout = findViewById(R.id.tab);

        String[] tabTitles = {"HANOI", "PARIS", "TOULOUSE"};

        // Link the TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    tab.setText(tabTitles[position]);
                }).attach();
    }

    // Override the onCreateOptionsMenu method
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.header_tool_bar, menu);
        return true;
    }


    // Handle the Reload Action and More Action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_reload) {
            //networkSimulationRequest();
            new NetworkSimulationRequest().execute();
            return true;
        } else if (itemId == R.id.action_more) {
            // Start PrefActivity when the settings option is clicked
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // AsyncTask to simulate a network request
    private class NetworkSimulationRequest extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            Toast.makeText(WeatherActivity.this, "Refreshing data...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void...voids){
            try{
                // Wait for 5 seconds to simulate a long network access
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Data refreshed successfully!";
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            // Show the result as a Toast
            Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Weather Activity", "Start the Android");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Weather Activity", "Resume whatever you are doing");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Weather Activity", "Pause what you are doing");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Weather Activity", "Stop !");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Weather Activity", "Destroy your activity");
    }
}