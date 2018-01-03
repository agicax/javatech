package info.androidhive.firebase;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ListAdsActivity extends AppCompatActivity {

    // [START declare_database_ref]

    private Button addAdBtn, logindBtn, signoutBtn;
    private FirebaseAuth auth;

    //esemenyek listazasara hasznaljuk
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ads);
        addAdBtn = (Button) findViewById(R.id.addadvertisement);
        logindBtn = (Button) findViewById(R.id.signin);
        //signoutBtn = (Button) findViewById(R.id.btn_sign_out);
        //auth = FirebaseAuth.getInstance();
        /*if (auth.getCurrentUser() != null){
            logindBtn.setVisibility(View.GONE);
            signoutBtn.setVisibility(View.VISIBLE);
        } else {
            logindBtn.setVisibility(View.VISIBLE);
            signoutBtn.setVisibility(View.GONE);
        }*/
        /*////*-------------------
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ads");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> values = (ArrayList<String>) dataSnapshot.getValue();
                recyclerView.setAdapter(new RecyclerViewAdapter(values));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read value." + error.toException());
            }
        });
        ////-------------------*/
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(ListAdsActivity.this, "List Ads Activity", Toast.LENGTH_SHORT).show();
        addAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListAdsActivity.this, AddNewAdvertisementActivity.class); //1param: honnan, hova
                startActivity(intent);
            }
        });

        logindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListAdsActivity.this, LoginActivity.class); //1param: honnan, hova
                startActivity(intent);
            }
        });
        /*signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();

            }
        });*/
    }

    private class GetDataFromFirebase extends AsyncTask<Void,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }

    /*public void signOut() {
        auth.signOut();
    }*/
}
