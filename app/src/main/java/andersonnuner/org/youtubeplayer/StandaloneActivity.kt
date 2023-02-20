package andersonnuner.org.youtubeplayer

import andersonnuner.org.youtubeplayer.databinding.ActivityStandaloneBinding
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityStandaloneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandaloneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPlayVideo.setOnClickListener(this)
        binding.btnPlayList.setOnClickListener(this)

//        btnPlayVideo.setOnClickListener(object  : View.OnClickListener {
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })

//        btnPlayVideo.setOnClickListener(View.OnClickListener { v ->
//            TODO("Not yet implemented")
//        })

//        val listener = View.OnClickListener { v ->
//            TODO("Not yet implemented")
//        }
//        btnPlayVideo.setOnClickListener(listener)
//        btnPlayList.setOnClickListener(listener)
    }

    override fun onClick(view: View?) {
        val intent = when (view?.id) {
            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
                this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false
            )
            R.id.btnPlayList -> YouTubeStandalonePlayer.createPlaylistIntent(
                this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST, 0, 0, true, true
            )
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}