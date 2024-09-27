package vn.edu.usth.weather;

import android.content.pm.PackageManager;
import android.icu.util.Output;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_STORAGE = 112;

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

        // Add the Header Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HeaderFragment headerFragment = new HeaderFragment();

        fragmentTransaction.replace(R.id.header_fragment, headerFragment);

        fragmentTransaction.commit();

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

        // Request to permission to write to external storage
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);
        } else {
            copyMusicFileToSdCard();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_STORAGE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            copyMusicFileToSdCard();
        }
    }

    // Copy the MP3 file from res/raw to external storage
    private void copyMusicFileToSdCard() {
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.sample);
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath() + "/Music/");
            dir.mkdirs();
            File file = new File(dir, "output.mp3");

            OutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();

            playMusic(file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Play the copied music file using MediaPlayer
    private void playMusic(File musicFile) {
        try{
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(musicFile.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
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