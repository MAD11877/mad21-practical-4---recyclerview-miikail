package npp.edu.sg.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    private String number;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Main Activity Created");

        TextView nameTxt = findViewById(R.id.nameTextView);
        TextView descTxt = findViewById(R.id.descTextView);

        String name = "Name not set";
        String desc = "Description not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("name");
            desc = extras.getString("desc");
        }

        nameTxt.setText(name);
        descTxt.setText("Description " + desc);

        Button followButton = findViewById(R.id.followButton);
        Button msgButton = findViewById(R.id.msgButton);

        int id = getIntent().getIntExtra("id", 0);
        Boolean followed = getIntent().getBooleanExtra("followed", false);
        User user = new User(name, desc, id, followed);


        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Pressed!");

                if(user.isFollowed() == false) {
                    followButton.setText("Unfollow");
                    user.followed = true;
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else if (user.isFollowed() == true) {
                    followButton.setText("Follow");
                    user.followed = false;
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(TAG, "Destroy");
    }
}