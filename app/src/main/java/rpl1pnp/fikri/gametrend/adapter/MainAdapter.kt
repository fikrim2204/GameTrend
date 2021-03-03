package rpl1pnp.fikri.gametrend.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import rpl1pnp.fikri.gametrend.databinding.ItemListBinding
import rpl1pnp.fikri.gametrend.model.Game

class MainAdapter(private var item: List<Game> , private val listener: (Game) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    class MainViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(game: Game, listener: (Game) -> Unit) {
            Picasso.get().load(game.image).resize(340,200).into(binding.imgItemPhoto)
            binding.tvItemName.text = "${game.id}.  ${game.name}"
            binding.tvItemPlatform.text = "Platform : ${game.platform}}"
            binding.tvItemDev.text = "Developer : ${game.developer}"
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