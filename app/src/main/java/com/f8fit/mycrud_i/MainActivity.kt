package com.f8fit.mycrud_i

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.f8fit.mycrud_i.home.HomeScreen
import com.f8fit.mycrud_i.home.HomeViewModel
import com.f8fit.mycrud_i.home.ProductDatabase
import com.f8fit.mycrud_i.ui.theme.MyCrud_ITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCrud_ITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database =
                        Room.databaseBuilder(this, ProductDatabase::class.java, "product_db")
                            .build()
                    val dao = database.dao
                    val viewModel by viewModels<HomeViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return HomeViewModel(dao) as T
                            }
                        }
                    })
                    HomeScreen(viewModel)
                }
            }
        }
    }
}