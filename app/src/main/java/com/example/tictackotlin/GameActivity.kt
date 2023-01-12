package com.example.tictackotlin

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.winner_dialouge.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
    var cnt=0
    var nowinner=0
    fun buClick(view: View){
        cnt++
        if(cnt==9){
            nowinner=3
            checkWinner()
            cnt=0
        }
        var cellId=0
        val buSelected = view as Button

        when(buSelected.id){
            R.id.b1 -> cellId = 1
            R.id.b2 -> cellId = 2
            R.id.b3 -> cellId = 3
            R.id.b4 -> cellId = 4
            R.id.b5 -> cellId = 5
            R.id.b6 -> cellId = 6
            R.id.b7 -> cellId = 7
            R.id.b8 -> cellId = 8
            R.id.b9 -> cellId = 9
        }
        playGame(cellId, buSelected)
    }
    var activePlayer=1
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    fun playGame(cellId: Int,buSelected: Button){

        if(activePlayer==1){
            buSelected.text= "X"
            buSelected.setBackgroundResource(R.drawable.box)
            player1.add(cellId)
            activePlayer=2;
        }else{
            buSelected.text= "O"
            buSelected.setBackgroundResource(R.drawable.box)
            player2.add(cellId)
            activePlayer=1;
        }
        buSelected.isEnabled= false
        checkWinner()

    }
    fun checkWinner(){
        var winner=-1;
        //row 1 winner
        if(player1.contains(1) && player1.contains(2)&&player1.contains(3)){
            winner= 1;
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner= 2;
        }
        //row 2 winner
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner= 1;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner= 2;
        }
        //row 3 winner
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner= 1;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner= 2;
        }

        //col 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner= 1;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner= 2;
        }
        //col 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner= 1;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner= 2;
        }
        //col 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner= 1;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner= 2;
        }

        //diagonal 1-5-9
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner= 1;
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner= 2;
        }
        //dia 3-5-7
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner= 1;
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner= 2;
        }

        if(winner==1){
            val dialog= Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialouge)
            dialog.winner.text= "X has won the game!"

            dialog.playAgain.setOnClickListener(){
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.exit.setOnClickListener(){
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent )
            }
            dialog.show()

        }
        else if(winner ==2){
            val dialog= Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialouge)
            dialog.winner.text= "O has won the game!"

            dialog.playAgain.setOnClickListener(){
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.exit.setOnClickListener(){
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent )
            }
            dialog.show()
        }
        else if(nowinner ==3){
            val dialog= Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialouge)
            dialog.winner.text= "No one is the winner!"

            dialog.playAgain.setOnClickListener(){
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.exit.setOnClickListener(){
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent )
            }
            dialog.show()
        }
    }
}