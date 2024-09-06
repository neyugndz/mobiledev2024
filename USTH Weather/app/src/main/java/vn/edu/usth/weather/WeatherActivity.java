package vn.edu.usth.weather;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        // Obtain the FragmentManager to handle fragment transactions
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Create instances of the fragments to be added
        HeaderFragment headerFragment = new HeaderFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        ForestFragment forestFragment = new ForestFragment();

        // Add WeatherFragment to the container with ID weather_fragment_container and ForestFragment
        fragmentTransaction.add(R.id.header_fragment, headerFragment);
        fragmentTransaction.add(R.id.weather_fragment, weatherFragment);
        fragmentTransaction.add(R.id.forest_fragment, forestFragment);

        // Commit the transaction to display the fragments
        fragmentTransaction.commit();
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