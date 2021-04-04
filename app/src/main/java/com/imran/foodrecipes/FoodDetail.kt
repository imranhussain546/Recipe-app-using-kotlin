package com.imran.foodrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        var bundle:Bundle? =intent.extras
        detailIV.setImageResource(bundle!!.getInt("image"))
        detailTV.setText(bundle!!.getString("name"))
        detaildescTV.setText(bundle!!.getString("desc"))
    }
}