package com.iavariav.ta_mobile_programming.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.helper.Config
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnCekData.setOnClickListener {
            if (edtUsername.text.isEmpty() || edtToken.text.isEmpty()){
                Toast.makeText(this, "Isi kolom dengan benar", Toast.LENGTH_LONG).show()
            } else{

                val intent: Intent = Intent(this, DataActivity::class.java)
                intent.putExtra(Config.BUNDLE_NPM, edtUsername.text.toString().trim())
                intent.putExtra(Config.BUNDLE_KEY, edtToken.text.toString().trim())
                startActivity(intent)
            }
        }
    }
}
