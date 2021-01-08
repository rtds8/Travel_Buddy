package com.example.travel_buddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;

public interface MapLayout {
    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onMapReady(GoogleMap googleMap);
}
