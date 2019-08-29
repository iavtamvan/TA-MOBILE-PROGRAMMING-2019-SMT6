package com.iavariav.ta_mobile_programming.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.helper.Config
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        cvKlikDataDiriSaya.setOnClickListener {
            val intent: Intent = Intent(this, DataActivity::class.java)
            intent.putExtra(Config.BUNDLE_NPM, "16670025")
            intent.putExtra(Config.BUNDLE_KEY, "33c227f799464dac08f60f1b0d5770")
            startActivity(intent)
        }

        cvKlikCekDataDiri.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}
