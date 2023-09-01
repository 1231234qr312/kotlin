package com.example.marketproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketproject.databinding.ActivityItemListBinding

class MyAdapter (val MyItem:MutableList<MyItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityItemListBinding.inflate(inflater, parent, false)
        return Holder(binding)


    }

    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position: Int){
        holder.itemView.setOnClickListener{
        itemClick?.onClick(it,position)}

        if (holder is Holder) {
            holder.Object.text = MyItem[position].Object
            holder.address.text = MyItem[position].address
            holder.price.text = MyItem[position].price
            holder.liken.text = MyItem[position].liken.toString()
            holder.chatn.text = MyItem[position].chatn.toString()
            holder.opicture.setImageResource(MyItem[position].opicture)

        }
    }

    override fun getItemCount(): Int {
        return MyItem.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

inner class Holder(val binding: ActivityItemListBinding):RecyclerView.ViewHolder(binding.root){
    var Object =binding.Object
    var address=binding.address
    var price=binding.price
    var liken=binding.likeN
    var chatn=binding.chatN
    var opicture=binding.opicture


}
}

