package com.imran.foodrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.activity_recipe.*

class Recipe : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var foodlist = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)


        foodlist.add(Food("Paneer Tikka",getString(R.string.Paneertikka),R.drawable.paneertikka))
        foodlist.add(Food("Hydrabadi Biryani", getString(R.string.Hydrabadibiryani),R.drawable.biryani))
        foodlist.add(Food("Chicken Barra",getString(R.string.Chickenbarra),R.drawable.chikenbarra))
        foodlist.add(Food("Mutton Masala",getString(R.string.Muttonmasala),R.drawable.muttonmasala))
        foodlist.add(Food("Paneer Butter",getString(R.string.Paneerbutter),R.drawable.paneerbutter))
        foodlist.add(Food("Mutton kawab",getString(R.string.Muttonkawab),R.drawable.muttonkawab))

        adapter=FoodAdapter(this,foodlist)
        gridview.adapter=adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navmenu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.navlogout-> {
                LoginManager.getInstance().logOut()
                startActivity(Intent(this, MainActivity::class.java))
            }

        }

        return super.onOptionsItemSelected(item)
    }
}