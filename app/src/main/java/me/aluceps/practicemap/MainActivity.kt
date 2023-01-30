package me.aluceps.practicemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
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

        val mapFragment = SupportMapFragment.newInstance()
        val callback = OnMapReadyCallback {
            val tokyo = LatLng(35.6892864, 139.6899497)
            val zoom = 10f
            it.addMarker(MarkerOptions().position(tokyo).title("tokyo"))
            it.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(tokyo, zoom)))
        }

        mapFragment.getMapAsync(callback)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, mapFragment)
            .commit()
    }
}
