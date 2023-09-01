package com.example.marketproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import androidx.core.content.res.ResourcesCompat
import com.example.marketproject.databinding.ActivityDetailBinding
import com.example.marketproject.databinding.ActivityMainBinding
import java.lang.System.exit
import java.text.DecimalFormat

class detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val itemPosition:Int by lazy{
        intent.getIntExtra(constants.ITEMINDEX,0)
    }
    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(constants.ITEMOBJECT,MyItem::class.java)
        } else {
            intent.getParcelableExtra<MyItem>(constants.ITEMOBJECT)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.opicture.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.opicture,
                null
            )
        })
        binding.name.text=item?.name
        binding.address.text=item?.address
        binding.detail.text=item?.detail
        binding.price.text=DecimalFormat("#,###").format(item?.price)+"원"
        binding.Object.text=item?.Object


    binding.back.setOnClickListener {
        exit()
    }



    }
    fun exit(){
        finish()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        exit()
    }

    }

