package rpl1pnp.fikri.gametrend.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import rpl1pnp.fikri.gametrend.R
import rpl1pnp.fikri.gametrend.adapter.MainAdapter
import rpl1pnp.fikri.gametrend.databinding.ActivityMainBinding
import rpl1pnp.fikri.gametrend.model.Game
import rpl1pnp.fikri.gametrend.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val viewModel : MainViewModel by viewModels()
    private var games: MutableList<Game> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainBinding.rvMain.layoutManager = LinearLayoutManager(this)
        initGame()
        adapter = MainAdapter(games) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("extra_item", it)
            startActivity(intent)
        }
        mainBinding.rvMain.adapter = adapter
    }

    fun initGame(){
        val id = resources.getStringArray(R.array.game_id)
        val photo = resources.obtainTypedArray(R.array.game_image)
        val name = resources.getStringArray(R.array.game_name)
        val developer = resources.getStringArray(R.array.game_developer)
        val platform = resources.getStringArray(R.array.game_platform)
        val info = resources.getStringArray(R.array.game_info)
        val player = resources.getStringArray(R.array.game_online_player)

        games.clear()
        for (i in id.indices) {
            games.add(
                Game(
                    id[i],
                    name[i],
                    photo.getResourceId(i, 0),
                    platform[i],
                    info[i],
                    player[i],
                    developer[i],
                    platform[i]
                )
            )
        }
        photo.recycle()
    }
}