package com.example.uklcafe;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.uklcafe.database.CafeDatabase
import com.example.uklcafe.database.Meja


class AddMejaActivity : AppCompatActivity() {
    lateinit var inputNama: TextView
    lateinit var simpanButton: Button

    lateinit var db: CafeDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_meja)

        inputNama = findViewById(R.id.inputNamaMeja)
        simpanButton = findViewById(R.id.buttonSimpan)

        db = CafeDatabase.getInstance(applicationContext)

        simpanButton.setOnClickListener{
            if(inputNama.text.toString().isNotEmpty()){
                db.cafeDao().insertMeja(Meja(null, inputNama.text.toString()))
                Toast.makeText(applicationContext, "Meja berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}