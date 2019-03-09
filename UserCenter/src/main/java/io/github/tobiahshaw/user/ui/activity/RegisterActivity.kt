package io.github.tobiahshaw.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.tobiahshaw.user.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener {
            Toast.makeText(this, "register", Toast.LENGTH_SHORT).show()
        }
    }
}
