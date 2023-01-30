package me.aluceps.practicemap

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import me.aluceps.practicemap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupMap()
    }

    private fun setupMap() {
        MapsInitializer.initialize(applicationContext, MapsInitializer.Renderer.LATEST) { renderer ->
            when (renderer) {
                MapsInitializer.Renderer.LEGACY -> Log.d("MapsDemo", "The latest version of the renderer is used.")
                MapsInitializer.Renderer.LATEST -> Log.d("MapsDemo", "The legacy version of the renderer is used.")
            }
        }

        val mapOptions = GoogleMapOptions()
            .mapType(GoogleMap.MAP_TYPE_NORMAL)
            .compassEnabled(false)
            .rotateGesturesEnabled(false)
            .tiltGesturesEnabled(false)

        val callback = OnMapReadyCallback {
            val tokyo = LatLng(35.6892864, 139.6899497)
            val zoom = 10f
            it.addMarker(MarkerOptions().position(tokyo).title("tokyo"))
            it.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(tokyo, zoom)))
        }

        val mapFragment = SupportMapFragment.newInstance(mapOptions)
        mapFragment.getMapAsync(callback)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, mapFragment)
            .commit()
    }
}
