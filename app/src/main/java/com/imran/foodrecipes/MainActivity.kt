package com.imran.foodrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var callbackManager:CallbackManager
    private val EMAIL="email"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()
        login_button.setOnClickListener {
          //  LoginManager.getInstance().logInWithReadPermissions(this,Arrays.asList("email","public_profile"))

            LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult?) {
                    var intent= Intent(this@MainActivity,Recipe::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onCancel() {
                    TODO("Not yet implemented")
                }

                override fun onError(error: FacebookException?) {
                    Toast.makeText(this@MainActivity,error.toString(),Toast.LENGTH_SHORT)
                }

            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)
    }


    override fun onResume() {
        super.onResume()
        if (AccessToken.getCurrentAccessToken()!=null)
        {
            var intent= Intent(this@MainActivity,Recipe::class.java)
            startActivity(intent)
            finish()
        }

    }
}