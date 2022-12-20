package com.example.mvvm_kullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mvvm_kullanimi.ui.theme.MVVM_kullanimiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_kullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Anasayfa()
                }
            }
        }
    }
}

@Composable
fun Anasayfa() {
    val tfSayi1 = remember { mutableStateOf("") }
    val tfSayi2 = remember { mutableStateOf("") }
    val sonuc = remember { mutableStateOf("0") }
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = sonuc.value, fontSize = 50.sp)
    TextField(value = tfSayi1.value, onValueChange = {tfSayi1.value = it})
    TextField(value = tfSayi2.value, onValueChange = {tfSayi2.value = it})
    Button(onClick = {
        val alinansayi1 = tfSayi1.value
        val alinansayi2 = tfSayi2.value
        val sayi1 = alinansayi1.toInt()
        val sayi2 = alinansayi2.toInt()

        val toplam = sayi1 + sayi2
        sonuc.value = toplam.toString()
    }) {
        Text(text = "Toplama")
    }

    Button(onClick = {
        val alinansayi1 = tfSayi1.value
        val alinansayi2 = tfSayi2.value
        val sayi1 = alinansayi1.toInt()
        val sayi2 = alinansayi2.toInt()

        val vuruq = sayi1 * sayi2
        sonuc.value = vuruq.toString()
    }) {
        Text(text = "Çarpma")
    }

}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_kullanimiTheme {
        Anasayfa()
    }
}