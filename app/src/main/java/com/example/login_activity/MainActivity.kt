package com.example.login_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var ID:EditText
    private lateinit var Pass:EditText
    private lateinit var login:Button

    var startAcSignUpActivity=registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val nameValue=data?.getStringExtra("signName")
            val IdValue = data?.getStringExtra("signId")
            val passValue = data?.getStringExtra("signPass")

            if (IdValue != null && passValue != null) {
                ID.setText(IdValue)
                Pass.setText(passValue)
                name.setText(nameValue)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val join:Button=findViewById(R.id.join)
        join.setOnClickListener{
            startAcSignUpActivity.launch(Intent(this, signupActivity::class.java))
        }
        name = findViewById(R.id.name)
        ID= findViewById(R.id.ID)
        Pass = findViewById(R.id.pass)
        login=findViewById(R.id.login)
        login.setOnClickListener{
            onClick2()
        }




        }



    fun onClick(view: View){
        val intent= Intent(this,signupActivity::class.java)
        startActivity(intent)

    }
    fun onClick2(){
        val nameValue = name.text.toString()
        val idValue = ID.text.toString()

        val intent = Intent(this, myselfActivity::class.java)
        intent.putExtra("Name_Key", nameValue)
        intent.putExtra("ID_Key", idValue)
        startActivity(intent)
    }
    }


