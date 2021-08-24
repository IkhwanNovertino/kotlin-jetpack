package com.a1631770.ikhwanov.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.a1631770.ikhwanov.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	//private lateinit var viewModel: MainViewModel
	private val viewModel: MainViewModel by viewModels() //menggunakna activity-ktx

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		//viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

		displayResult()

		binding.btnCalculate.setOnClickListener {
			val length = binding.edtLength.text.toString()
			val width = binding.edtWidth.text.toString()
			val heigth = binding.edtHeight.text.toString()

			when {
				length.isEmpty() -> { binding.edtLength.error = "Masih Kosong" }
				width.isEmpty() -> { binding.edtWidth.error = "Masih Kosong" }
				heigth.isEmpty() -> { binding.edtHeight.error = "Masih Kosong" }
				else -> {
					viewModel.calculate(width, heigth, length)
					displayResult()
				}
			}
		}
	}

	private fun displayResult() {
		binding.tvResult.text = viewModel.result.toString()
	}
}