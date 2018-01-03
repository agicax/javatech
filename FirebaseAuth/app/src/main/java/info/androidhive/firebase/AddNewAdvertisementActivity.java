package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewAdvertisementActivity extends AppCompatActivity {
    private EditText mTitle;
    private EditText mDescription;
    private EditText mLocation;
    private Button saveAdBtn;
    private FirebaseDatabase mFirebaseInstance;
    private DatabaseReference mFirebaseDatabase;
    private String adId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_advertisement);

        final EditText mTitle = (EditText) findViewById(R.id.ad_title);
        final EditText mDescription = (EditText) findViewById(R.id.ad_description);
        final EditText mLocation = (EditText) findViewById(R.id.ad_location);
        saveAdBtn = (Button) findViewById(R.id.save_ad);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'ads' node
        mFirebaseDatabase = mFirebaseInstance.getReference("ads");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Advertisements");

        // Save / update the user
        saveAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitle.getText().toString();
                String description = mDescription.getText().toString();
                String location = mLocation.getText().toString();

                // Check for already existed advertId
                if (TextUtils.isEmpty(adId)) {
                    createAd(title, description, location);
                    startActivity(new Intent(AddNewAdvertisementActivity.this, ListAdsActivity.class));

                } else {
                    Toast.makeText(AddNewAdvertisementActivity.this, "failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void createAd(String title, String description, String location) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(adId)) {
            adId = mFirebaseDatabase.push().getKey();
        }

        Advertisement ad = new Advertisement(title, description, location);

        mFirebaseDatabase.child(adId).setValue(ad);

    }
}
