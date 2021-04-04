package com.imran.foodrecipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.card.view.*
import java.util.zip.Inflater

class FoodAdapter : BaseAdapter {
    var foodlist = ArrayList<Food>()
    var context : Context? = null

    constructor(context: Context?, foodlist: ArrayList<Food>) : super() {
        this.foodlist = foodlist
        this.context = context
    }

    override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
      var food : Food =this.foodlist[index]
      var inflater : LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
      var foodview = inflater.inflate(R.layout.card,null)
        foodview.cardiv.setImageResource(food.image!!)
        foodview.cardtv.text=food.name!!

        foodview.cardiv.setOnClickListener {
            var intent =Intent(context,FoodDetail::class.java)
            intent.putExtra("name",food.name!!)
            intent.putExtra("desc",food.des!!)
            intent.putExtra("image",food.image!!)
            context!!.startActivity(intent)
        }
        return foodview
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return foodlist.size
    }

}
