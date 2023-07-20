package com.example.bebagua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import com.example.bebagua.Model.Pessoa
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tpHoraAcorda = findViewById<TimePicker>(R.id.tpHoraAcorda)
        val tpHoraDorme = findViewById<TimePicker>(R.id.tpHoraDorme)
        tpHoraAcorda.setIs24HourView(true)
        tpHoraDorme.setIs24HourView(true)

        btn.setOnClickListener{
            var testeHora = tpHoraAcorda.getCurrentHour()
            var testeMinuto = tpHoraAcorda.getCurrentMinute()
            var testeHoraAcorda = (testeHora*60)+testeMinuto
            testeHora = tpHoraDorme.getCurrentHour()
            testeMinuto = tpHoraDorme.getCurrentMinute()
            var testeHoraDorme = (testeHora*60)+testeMinuto
            if(testeHoraDorme<testeHoraAcorda) {
                testeHoraDorme = testeHoraDorme + 1440
            }
            var testeTempoAcordado = testeHoraDorme-testeHoraAcorda
            if(etNome.text.isEmpty()){
                etNome.setHint("Informe o nome")
                etNome.requestFocus()
            }else if (etPeso.text.isEmpty()){
                etPeso.setHint("Informe o peso")
                etPeso.requestFocus()
            }else if(testeTempoAcordado<480){
                tvHoraIncorreta.visibility = View.VISIBLE
                tpHoraAcorda.requestFocus()
            }else{
                val pessoa = Pessoa()
                pessoa.nome = etNome.text.toString()
                pessoa.peso = etPeso.text.toString().toDouble()
                var hora = tpHoraAcorda.getCurrentHour()
                var minuto = tpHoraAcorda.getCurrentMinute()
                pessoa.horaAcorda = (hora*60)+minuto
                hora = tpHoraDorme.getCurrentHour()
                minuto = tpHoraDorme.getCurrentMinute()
                pessoa.horaDorme = (hora*60)+minuto
                pessoa.calcularTempoAcordado()
                pessoa.calcularIntervaloEntreCopos()
                pessoa.preencherHorarios()
                pessoa.preencherHorariosemString()
                val intent = Intent (this, ActivityResultado::class.java)
                intent.putExtra("PESSOA",pessoa)
                startActivity(intent)
            }
        }
    }
}

