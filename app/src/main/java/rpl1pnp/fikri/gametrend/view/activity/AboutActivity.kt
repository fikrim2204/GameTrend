package rpl1pnp.fikri.gametrend.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import rpl1pnp.fikri.gametrend.R
import rpl1pnp.fikri.gametrend.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAbout)
        supportActionBar?.title = getText(R.string.profile)
        backButton()

        initProfile()
    }

    private fun backButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initProfile() {
        Picasso.get().load(R.drawable.img7010_croped).into(binding.imgProfilePhoto)
        binding.tvProfileName.text = getText(R.string.profile_name)
        binding.tvProfileEmail.text = getText(R.string.profile_email)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}