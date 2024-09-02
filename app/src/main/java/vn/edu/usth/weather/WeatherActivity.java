package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {

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
        //Create a new Fragment to be placed in the activity layout
        ForestFragment forestFragment = new ForestFragment();
        //Add the fragment to the 'container' Frame Layout
        getSupportFragmentManager().beginTransaction().add(R.id.main ,forestFragment).commit();
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