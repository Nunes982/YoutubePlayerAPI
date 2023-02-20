package andersonnuner.org.youtubeplayer

import andersonnuner.org.youtubeplayer.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPlaySingle.setOnClickListener(this)
        binding.btnStandalone.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = when (view?.id) {
            R.id.btnPlaySingle -> Intent(this, YoutubeActivity::class.java)
            R.id.btnStandalone -> Intent(this, StandaloneActivity::class.java)
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}