package info.androidhive.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Agi-CAX on 11/4/2017.
 */

public class Advertisement {
    private String title;
    private String description;
    private String location;
    //private Date date;
    //private List<&Image> images;
    private DatabaseReference mDatabase;


    public Advertisement(String title, String description, String location) {
        this.title = title;
        this.description = description;
        this.location = location;
        //this.date = new Date();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
