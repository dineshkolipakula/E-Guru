package echo.school.com;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity
        {

    static boolean active = false;
            private TextView mTextMessage;

            private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                    = new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:

                            return true;
                        case R.id.menu:

                            return true;
                        case R.id.nav_donate:
                            startActivity(new Intent(MainActivity2.this, Profile.class));

                            return true;
                    }
                    return false;
                }

            };



   // private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Welcome to E-Guru";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }

                        Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        initialize();

    }

            private void initialize() {
                ((ListView) findViewById(R.id.items_list)).setAdapter(new HomeItemAdapter(this));
            }

            private void powerUpOnClickListener(HomeItemAdapter.Item item) {
                switch (item.getName()) {
                    case "Maths":
                      //  startActivity(new Intent(menu11.this, website.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;

                    case "Chemistry":
                       // startActivity(new Intent(menu11.this, SupportActivity.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();

                        break;
                    case "Physics":
                        //   startActivity(new Intent(menu11.this, Chatactivity.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;

                    case "Biology":
                       // startActivity(new Intent(menu11.this, pastevents.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;
                    case "Computer Science":
                      //  startActivity(new Intent(menu11.this, upcomevents.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;

                    case "Social":
                    //    startActivity(new Intent(menu11.this, NewsActivity.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();

                        break;

                    case "English":
                       // startActivity(new Intent(menu11.this, MapsActivity.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;


                    case "Hindi":

                       // startActivity(new Intent(menu11.this, eventimages.class));
                        Toast.makeText(MainActivity2.this,"No Teacher found",Toast.LENGTH_SHORT).show();
                        break;






                }
            }

            class HomeItemAdapter extends BaseAdapter {

                private List<Item> items = new ArrayList<>();
                private LayoutInflater inflater;
                private Context context;

                HomeItemAdapter(Context context) {

                    this.context = context;
                    inflater = LayoutInflater.from(context);
                    items.clear();

                    items.add(new Item("#259b24", "Maths"));
                    items.add(new Item("#259b24", "Physics"));
                    items.add(new Item("#259b24", "Chemistry"));
                    items.add(new Item("#259b24", "Biology"));
                    items.add(new Item("#259b24", "Computer Science"));
                    items.add(new Item("#259b24", "Social"));
                    items.add(new Item("#259b24", "English"));
                    items.add(new Item("#259b24", "Hindi"));



                }

                @Override
                public int getCount() {
                    return items.size();
                }

                @Override
                public Object getItem(int i) {
                    return items.get(i);
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    View v = view;
                    ImageView picture;
                    TextView name;

                    if (v == null) {
                        v = inflater.inflate(R.layout.item_main_grid, viewGroup, false);
                        v.setTag(R.id.landing_item_holder, v.findViewById(R.id.landing_item_holder));
                       // v.setTag(R.id.landing_picture, v.findViewById(R.id.landing_picture));
                        v.setTag(R.id.landing_text, v.findViewById(R.id.landing_text));
                    }
// b                    picture = (ImageView) v.getTag(R.id.landing_picture);
                    name = (TextView) v.getTag(R.id.landing_text);

                    final Item item = (Item) getItem(i);
                  //  picture.setImageDrawable(new IconDrawable(context, item.image).color(Color.parseColor(item.color)));
                    name.setText(item.name);
                    //holder.setBackgroundColor(Color.parseColor(item.color));
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            powerUpOnClickListener(item);
                        }
                    });
                    return v;
                }

                private class Item {

                    final String color;
                    final String name;

                    Item(String color, String name) {
                        this.color = color;
                        this.name = name;
                    }

                    public String getName() {
                        return name;
                    }
                }
            }
        }
