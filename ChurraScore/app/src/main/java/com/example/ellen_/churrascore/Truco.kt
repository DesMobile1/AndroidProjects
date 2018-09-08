package com.example.ellen_.churrascore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_truco.*

class Truco : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truco)

        var pontos1 : Int = 0
        var pontos2 : Int = 0
        var time1selecionado : Boolean = false
        var time2selecionado : Boolean = false

        time1.setOnClickListener(){
            if(!time1selecionado) {
                time1selecionado = true
                time2selecionado = false
                Toast.makeText(this, "Time 1 selecionado", Toast.LENGTH_SHORT).show()
            }
            else {
                time1selecionado = false
            }
        }

        time2.setOnClickListener(){
            if(!time2selecionado) {
                time2selecionado = true
                time1selecionado = false
                Toast.makeText(this, "Time 2 selecionado", Toast.LENGTH_SHORT).show()
            }
            else {
                time2selecionado = false
            }
        }

        botao1.setOnClickListener(){
            if(time1selecionado){
                pontos1++
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2++
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }

        botao2.setOnClickListener(){
            if(time1selecionado){
                pontos1--
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2--
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }

        botao3.setOnClickListener(){
            if(time1selecionado){
                pontos1+=3
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2+=3
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }

        botao4.setOnClickListener(){
            if(time1selecionado){
                pontos1+=6
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2+=6
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }

        botao5.setOnClickListener(){
            if(time1selecionado){
                pontos1+=9
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2+=9
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }

        botao6.setOnClickListener(){
            if(time1selecionado){
                pontos1+=12
                placar1.text = pontos1.toString()
            }
            else if(time2selecionado){
                pontos2+=12
                placar2.text = pontos2.toString()
            }
            else{
                Toast.makeText(this, "Selecione o time", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
