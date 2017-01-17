package pro.pro.probuilt.pro.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.pro.probuilt.pro.R;

/**
 * Created by rhfoq on 2016-12-25.
 */
public class ContactFragment extends Fragment implements OnMapReadyCallback {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("CONTACT");
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        MapView mapview=(MapView)rootView.findViewById(R.id.mapView);
        mapview.onCreate(savedInstanceState);
        mapview.onResume();
        mapview.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(34.018756, -118.207465)));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        googleMap.animateCamera(zoom);

        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(34.018756, -118.207465))
                .title("Pro-Built")
                .snippet("Pro-Built");
        googleMap.addMarker(marker).showInfoWindow();

        String languageToLoad = "en";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getActivity(),marker.getTitle()+"클릭", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
