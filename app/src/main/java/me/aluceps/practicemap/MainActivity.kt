package me.aluceps.practicemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
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
        }

        mapFragment.getMapAsync(callback)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, mapFragment)
            .commit()
    }
}
