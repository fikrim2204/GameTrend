package rpl1pnp.fikri.gametrend.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import rpl1pnp.fikri.gametrend.databinding.ItemListBinding
import rpl1pnp.fikri.gametrend.model.Game

class MainAdapter(private val listener: (Game) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var item: List<Game> = mutableListOf()

    class MainViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(game: Game, listener: (Game) -> Unit) {
            Picasso.get().load(game.image).into(binding.imgItemPhoto)
            binding.tvItemName.text = game.name
            binding.tvItemPlatform.text = game.platform
            binding.tvItemDev.text = game.developer
            itemView.setOnClickListener { listener(game) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    override fun getItemCount() = item.size
}