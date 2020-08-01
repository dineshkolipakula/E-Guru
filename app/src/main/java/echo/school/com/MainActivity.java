package echo.school.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH = 4000;

    Animation topanim, bottomanim;
    ImageView image;
    TextView logo, slogan;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activitymain);
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        image = findViewById(R.id.logo);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView3);
        image.setAnimation(topanim);
        logo.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }

        },SPLASH);
    }
}