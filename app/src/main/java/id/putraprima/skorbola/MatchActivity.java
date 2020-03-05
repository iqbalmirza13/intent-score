package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private TextView homeText;
    private TextView awayText;
    private TextView HomeTextScore;
    private TextView AwayTextScore;
    private int homeScore;
    private int awayScore;
    String homeValue;
    String awayValue;
    private ImageView home_img, away_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        HomeTextScore = findViewById(R.id.score_home);
        AwayTextScore = findViewById(R.id.score_away);
        Bundle extras = getIntent().getExtras();
        homeValue = extras.getString("home");
        awayValue = extras.getString("away");
        home_img = findViewById(R.id.home_logo);
        away_img = findViewById(R.id.away_logo);

        if (extras != null) {
            String home = extras.getString(MainActivity.HOME_KEY);
            String away = extras.getString(MainActivity.AWAY_KEY);
            homeText.setText(home);
            awayText.setText(away);
            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("homeLogo"),0, getIntent().getByteArrayExtra("homeLogo").length);
            home_img.setImageBitmap(bmp);
            Bitmap bmpAway = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("awayLogo"),0, getIntent().getByteArrayExtra("awayLogo").length);
            away_img.setImageBitmap(bmpAway);

        }
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
    public void homeScore(View view){
        homeScore++;
        HomeTextScore.setText(String.valueOf(homeScore));
    }
    public void awayScore(View view){
        awayScore++;
        AwayTextScore.setText(String.valueOf(awayScore));
    }
    public void handleResult(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("HomeTextScore",homeScore);
        intent.putExtra("AwayTextScore",awayScore);
        intent.putExtra("homeName",homeValue);
        intent.putExtra("awayName",awayValue);
        startActivity(intent);
    }
}
