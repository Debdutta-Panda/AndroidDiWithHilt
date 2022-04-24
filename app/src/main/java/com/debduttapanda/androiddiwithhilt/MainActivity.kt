package com.debduttapanda.androiddiwithhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.debduttapanda.androiddiwithhilt.ui.theme.AndroidDiWithHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            AndroidDiWithHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn{
                        items(viewModel.list){
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                AsyncImage(
                                    model = it.image,
                                    contentDescription = "Image",
                                    modifier = Modifier.size(100.dp)
                                )
                                Spacer(
                                    modifier = Modifier.width(12.dp)
                                )
                                Text(it.name)
                            }
                        }
                    }
                }
            }
        }
    }
}