package com.katchkenny

import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.katchkenny.databinding.ActivityMainBinding
import java.util.Random
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    //Global Variables
    private var score = 0;
    private var highScore = 0;
    var imageArray = ArrayList<ImageView>()
    private lateinit var binding: ActivityMainBinding
    var handler = Handler(Looper.getMainLooper())
    var doItRepeatedly = Runnable {  }
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = this.getSharedPreferences("com.katchkenny", MODE_PRIVATE)
        highScore = sharedPreferences.getInt("high score",0)
        binding.highScore.text = "High Score : $highScore"

        //adding the images to the imageview array
        imageArray.add(binding.kenny1)
        imageArray.add(binding.kenny2)
        imageArray.add(binding.kenny3)
        imageArray.add(binding.kenny4)
        imageArray.add(binding.kenny5)
        imageArray.add(binding.kenny6)
        imageArray.add(binding.kenny7)
        imageArray.add(binding.kenny8)
        imageArray.add(binding.kenny9)
        imageArray.add(binding.kenny10)
        imageArray.add(binding.kenny11)
        imageArray.add(binding.kenny12)
        imageArray.add(binding.kenny13)
        imageArray.add(binding.kenny14)
        imageArray.add(binding.kenny15)
        imageArray.add(binding.kenny16)
        imageArray.add(binding.kenny17)
        imageArray.add(binding.kenny18)
        imageArray.add(binding.kenny19)
        imageArray.add(binding.kenny20)

        //hiding the images
        hideImages()

        binding.start.setOnClickListener(){

            score = 0
            binding.yourScore.text = "Your Score : $score"
            //hide message
            binding.message.visibility = View.GONE

            //countDown Timer
            object:CountDownTimer(15500,1000){
                override fun onTick(millisUntilFinished: Long) {
                    binding.timeLeft.text = "Time Left : " + millisUntilFinished/1000
                }

                override fun onFinish() {
                    for(kenny in imageArray){
                        handler.removeCallbacks(doItRepeatedly)
                        kenny.visibility = View.GONE
                    }
                    binding.message.visibility = View.VISIBLE
                    binding.message.text = "Great!!! You caught $score kenny.\n\nClick on Start to play again"
                    if (score>highScore){
                        highScore = score
                        binding.highScore.text = "High Score : $highScore"
                        sharedPreferences.edit().putInt("high score",highScore).apply()
                    }
                }
            }.start()

            //creating an illusion on animating at some interval of time by running runnables
            doItRepeatedly = object:Runnable{
                override fun run() {
                    for (kenny in imageArray) {
                        kenny.visibility = View.INVISIBLE
                    }
                    val random = Random()
                    val randomIndex = random.nextInt(19)
                    Log.i("Random",randomIndex.toString())
                    imageArray[randomIndex].visibility = View.VISIBLE
                    handler.postDelayed(doItRepeatedly, 400)
                }

            }
            handler.post(doItRepeatedly)
        }

        binding.reset.setOnClickListener(){
            highScore = 0
            score = 0
            sharedPreferences.edit().putInt("high Score",highScore).apply()
            binding.highScore.text = "High Score : $highScore"
            binding.yourScore.text = "Your Score : $score"
        }
    }

    private fun hideImages() {
        binding.message.visibility = View.VISIBLE
        for (kenny in imageArray) {
            kenny.visibility = View.GONE
        }
    }
    fun increaseScore(view: View){
        score += 1;
        binding.yourScore.text = "Your Score : $score"
    }
}