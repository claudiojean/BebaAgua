package com.example.bebagua.Model

import java.io.Serializable

class Pessoa(var nome: String="",
              var peso: Double=0.0,
              var horaAcorda: Int=0,
              var horaDorme: Int=0,
              var intervalo:Double = 0.0,
              var horarios: List<Int> = listOf(),
              var horarios2: Array<String> = arrayOf(),
              var tempoAcordado: Int=0):Serializable{
    fun calcularTempoAcordado (){
        if(horaDorme<horaAcorda) {
            horaDorme = horaDorme + 1440
        }
        tempoAcordado = horaDorme-horaAcorda
    }
    fun calcularIntervaloEntreCopos(){
        intervalo=tempoAcordado/(peso*35/250)
    }
    fun preencherHorarios(){
        horarios += horaAcorda
        for(i:Int in 1..tempoAcordado/intervalo.toInt() ){
            horarios += horarios.last()+intervalo.toInt()
        }
    }
    fun preencherHorariosemString(){

        for(horario in horarios){
            var min = horario.rem(60)
            var hr:Int
            if(horario/60>=24)
                hr=horario/60-24
            else
                hr=horario/60
            if(min<10 && hr<10)
                horarios2 += "0"+ hr +":0"+min
            else if (min>=10 && hr<10)
                horarios2 += "0"+ hr +":"+min
            else if (min<10 && hr>=10)
                horarios2 += ""+ hr +":0"+min
            else
                horarios2 += ""+ hr +":"+min
        }
    }

}