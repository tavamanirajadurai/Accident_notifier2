package com.example.accident_notifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase db =FirebaseDatabase.getInstance();
    FirebaseAuth mauth=FirebaseAuth.getInstance();
    String user=mauth.getCurrentUser().getUid();
    String currentid=mauth.getCurrentUser().getUid();
    DatabaseReference    reference =db.getReference().child(user);
    DatabaseReference ref=db.getReference();
    Button add,show;
    EditText namee,usernamee,drive,blood,phno,aadhar;
    String firstname,drivy,aad,ph,bl,username,uid;
    ArrayList list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namee=(EditText)findViewById(R.id.name);
        usernamee=(EditText)findViewById(R.id.user);
        drive=(EditText)findViewById(R.id.drive);
        blood=(EditText)findViewById(R.id.blood);
        phno=(EditText)findViewById(R.id.phno);
        aadhar=(EditText)findViewById(R.id.aadhar);
        add=(Button)findViewById(R.id.add);
        show=(Button)findViewById(R.id.show);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                firstname =namee.getText().toString() ;
                username =usernamee.getText().toString() ;
                drivy = drive.getText().toString();
                aad=aadhar.getText().toString();
                ph=phno.getText().toString();
                bl=blood.getText().toString();

                HashMap<String,String> map=new HashMap<>();
                map.put("userid",user);
                map.put("name",firstname);
                map.put("username",username);
                map.put("Dno",drivy);
                map.put("phno",ph);
                map.put("blood",bl);
                map.put("aadhar",aad);
                    reference.setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"user details created successful..!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }else{
                                Toast.makeText(getApplicationContext(),"login error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            }
        });

show.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(getApplicationContext(),homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
       /* ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    details feeds = dataSnapshot.getValue(details.class);
                    if(feeds.userid.equals(user)) {
                        Toast.makeText(getApplicationContext(), feeds.userid + " " + feeds.name, Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/


    }
});




    }

}