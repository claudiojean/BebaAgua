package com.example.bebagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.bebagua.Model.Pessoa
import kotlinx.android.synthetic.main.activity_resultado.*

class ActivityResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val pessoa = getIntent().getSerializableExtra("PESSOA") as? Pessoa
        val adapter = pessoa?.horarios2?.let { ArrayAdapter(this, android.R.layout.simple_list_item_1, it) }
        if (pessoa != null) {
            tvResultado.setText("É recomendável que ${pessoa.nome} tome um copo de água nos seguintes horários:")
        }
        list_view.adapter = adapter

    }
}