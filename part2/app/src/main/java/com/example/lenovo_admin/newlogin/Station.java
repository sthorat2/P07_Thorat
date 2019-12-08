package com.example.lenovo_admin.newlogin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Station extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
    }

    public void station1(View view) {
        String strUri = "http://maps.google.com/maps?q=loc:" + 18.530002 + "," + 73.861155 + " (" + "Florist Shop 1" + ")";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

        startActivity(intent);
    }

    public void station2(View view) {
        String strUri = "http://maps.google.com/maps?q=loc:" + 18.518278 + "," + 73.845236 + " (" + "Florist Shop 2" + ")";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

        startActivity(intent);
    }
    public void station3(View view) {
        String strUri = "http://maps.google.com/maps?q=loc:" + 18.518278 + "," + 73.845236 + " (" + "Florist Shop 3" + ")";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

        startActivity(intent);
    }
    public void station4(View view) {
        String strUri = "http://maps.google.com/maps?q=loc:" + 18.518278 + "," + 73.845236 + " (" + "Florist Shop 4" + ")";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

        startActivity(intent);
    }
}
