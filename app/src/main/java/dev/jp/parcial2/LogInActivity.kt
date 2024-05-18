package dev.jp.parcial2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }



        val user : EditText = findViewById(R.id.user)
        val password : EditText = findViewById(R.id.password)
        val btnIngresar : Button = findViewById(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val user : String = user.text.toString()
            val password : String = password.text.toString()

            if (user == "123" && password == "123"){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            Toast.makeText(this
                ,"Credenciales invalidas"
                ,Toast.LENGTH_LONG).show()
        }

    }
}
