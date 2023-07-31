package com.example.quizapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.data.model.Logo
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.presentation.viewmodel.GetLogoViewModel
import com.example.quizapp.presentation.Util
import com.example.quizapp.presentation.adapter.ScrambledCharAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<GetLogoViewModel>()

    private var ans:String = ""

    private var updatedText = ""

    private lateinit var scrambledCharAdapter: ScrambledCharAdapter

    private var mapOfLogo = HashMap<String,String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUIElements()
        addListeners()
        addObserver()
        GlobalScope.launch {
            viewModel.getLogoData()
        }
    }

    private fun setUIElements(){
        binding.apply {

            val listOfChars = Util.generateJumbledCharacters(ans)

            recyclerView.apply {
                layoutManager = GridLayoutManager(this@QuizActivity,5)

                adapter = ScrambledCharAdapter(onClick = ::updateAnswerTextView)

                scrambledCharAdapter = adapter as ScrambledCharAdapter

            }

            scrambledCharAdapter.updateList(listOfChars)

        }
    }

    private fun updateAnswerTextView(char:String){
        binding.apply {
            updatedText += char
            tvLogoName.text = updatedText
        }
    }

    private fun addObserver(){
        viewModel.logoLiveData.observe(this){
            populateLogoData(data =it)
            val imgUrl = it[Random.nextInt(it.size)].imgUrl
            ans = mapOfLogo[imgUrl].toString()
            val listOfChars = Util.generateJumbledCharacters(ans)
            scrambledCharAdapter.updateList(listOfChars)
            loadImage(imgUrl)
        }
    }

    private fun addListeners(){
        binding.apply {
            tvLogoName.addTextChangedListener(object :TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if(p0==ans){
                        Util.showSuccessToast("Answer is correct", this@QuizActivity)
                    }
                }

                override fun afterTextChanged(p0: Editable?) {

                }
            })
        }
    }

    private fun loadImage(imgUrl:String){
        binding.imageLogo.apply {
            Glide.with(this@QuizActivity).load(imgUrl).into(this)
        }
    }

    private fun populateLogoData(data:List<Logo>){
        mapOfLogo.apply {
            for (logo in data){
                put(logo.imgUrl,logo.name)
            }
        }
    }
}