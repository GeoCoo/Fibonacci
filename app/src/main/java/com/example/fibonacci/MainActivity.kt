package com.example.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Thread.yield
import kotlin.sequences.buildSequence as buildSequence

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val fibonacci = sequence {
            yield(1L)
            var current = 1L
            var next = 1L
            while (true) {
                yield(next)
                val tmpNext = current + next
                current = next
                next = tmpNext
            }
        }


        val indexed = fibonacci.take(50).withIndex()
        for ((index, value) in indexed) {
            Log.i("Fibo", "$index : $value")
        }
    }





}
