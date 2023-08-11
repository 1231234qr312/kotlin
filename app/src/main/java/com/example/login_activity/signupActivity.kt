package com.example.login_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.asJavaRandom


class signupActivity : AppCompatActivity() {
    public lateinit var name: EditText
    private lateinit var id: EditText
    private lateinit var pass: EditText
    private lateinit var signup: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signup =findViewById(R.id.signUp)


        name = findViewById(R.id.signName)
        id = findViewById(R.id.signId)
        pass = findViewById(R.id.signPass)



        signup.setOnClickListener{clickedView->
            checkToast()


        }
    }

    fun onclick(){
        val intent = Intent()
        intent.putExtra("signId", id.text.toString())
        intent.putExtra("signPass", pass.text.toString())
        intent.putExtra("signName",name.text.toString())
        setResult(RESULT_OK, intent)
        finish()

    }

    fun checkToast(){
        val inputId=id.text.toString().trim()
        val inputName=name.text.toString().trim()
        val inputPass=pass.text.toString().trim()

        if(inputId.isEmpty()||inputName.isEmpty()||inputPass.isEmpty()){
            Toast.makeText(this,"입력하지 않은 부분이 있습니다.",Toast.LENGTH_SHORT).show()
        }
        else{
            onclick()
        }
    }




}