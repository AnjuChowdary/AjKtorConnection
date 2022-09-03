package com.ae.ajktorconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ae.ajktorconnection.databinding.ActivityMainBinding
import com.ae.ajktorconnection.ktor.UserApi
import com.ae.ajktorconnection.ktor.UserRepository
import com.ae.ajktorconnection.ktor.ktorClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepository: UserRepository
    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository = UserRepository(UserApi(ktorClient))

        binding.invokeButton.setOnClickListener {
            launch {
                userRepository.getUserKtor("2")
            }
        }
    }
}