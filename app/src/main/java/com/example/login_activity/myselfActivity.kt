package com.example.login_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
class myselfActivity : AppCompatActivity() {

    private lateinit var nameView: TextView
    private lateinit var finishBtn: Button
    private lateinit var IdView: TextView
    private val imageArray=arrayOf(
        R.drawable.a1,
        R.drawable.a2,
        R.drawable.a3,
        R.drawable.a4,
        R.drawable.a5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myself)

        nameView = findViewById(R.id.nameView)
        IdView = findViewById(R.id.IdView)

        val receveName = intent.getStringExtra("Name_Key")
        nameView.text = receveName
        val receveId = intent.getStringExtra("ID_Key")
        IdView.text = receveId
        finishBtn=findViewById(R.id.finishBtn)

        randomImage()
        finishBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }
    private fun randomImage(){
        val randomIndex= Random.nextInt(imageArray.size)
        val imageShow=imageArray[randomIndex]
        val randomImageView = findViewById<ImageView>(R.id.randomImageView)
        randomImageView.setImageResource(imageShow)
    }
}
