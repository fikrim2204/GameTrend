package rpl1pnp.fikri.gametrend.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import rpl1pnp.fikri.gametrend.R
import rpl1pnp.fikri.gametrend.adapter.MainAdapter
import rpl1pnp.fikri.gametrend.databinding.ActivityMainBinding
import rpl1pnp.fikri.gametrend.model.Game

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private var games: MutableList<Game> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.title = getText(R.string.game_trend)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        initGame()
        adapter = MainAdapter(games) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("extra_item", it)
            startActivity(intent)
        }
        binding.rvMain.adapter = adapter
    }

    private fun initGame(){
        val id = resources.getStringArray(R.array.game_id)
        val photo = resources.obtainTypedArray(R.array.game_image)
        val name = resources.getStringArray(R.array.game_name)
        val developer = resources.getStringArray(R.array.game_developer)
        val platform = resources.getStringArray(R.array.game_platform)
        val info = resources.getStringArray(R.array.game_info)
        val player = resources.getStringArray(R.array.game_online_player)
        val year = resources.getStringArray(R.array.game_release_year)

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
                    year[i]
                )
            )
        }
        photo.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}