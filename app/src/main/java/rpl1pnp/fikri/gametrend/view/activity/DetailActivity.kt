package rpl1pnp.fikri.gametrend.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import rpl1pnp.fikri.gametrend.databinding.ActivityDetailBinding
import rpl1pnp.fikri.gametrend.model.Game

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var games: Game? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        games = intent.getParcelableExtra("extra_item")

        games?.let { Picasso.get().load(it.image).into(binding.imgItemPhotoDetail) }

        val name = games?.name
        val developer = "Developer : ${games?.developer}"
        val platform = "Platform : ${games?.platform}"
        val player = "Player : ${games?.player}"
        binding.tvItemNameDetail.text = name
        binding.tvItemDevDetail.text = developer
        binding.tvItemPlatformDetail.text = platform
        binding.tvItemPlayerDetail.text = player
        binding.tvItemDescription.text = games?.info
    }
}