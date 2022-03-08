package com.example.accident_notifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {
    TextView bp = (TextView)findViewById(R.id.level);
    Button sub = (Button) findViewById(R.id.button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num = Integer.parseInt(bp.getText().toString());
                if(num>=90 && num<120) {
                    Toast.makeText(getApplicationContext(),"Normal",Toast.LENGTH_LONG).show();
                }
                if(num>=120 && num<129) {
                    Toast.makeText(getApplicationContext(),"increase in blood pressure",Toast.LENGTH_LONG).show();
                }
                if(num>=130) {
                    Intent i = new Intent(getApplicationContext(), detect.class);
                    startActivity(i);

                }

            }
        });
    }
}