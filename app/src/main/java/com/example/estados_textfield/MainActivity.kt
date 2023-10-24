package com.example.estados_textfield

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estados_textfield.ui.theme.EstadosTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadosTextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Pantalla()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla() {
    var myText by rememberSaveable {
        mutableStateOf("")
    }

 Column (
     modifier=Modifier
     .fillMaxSize(),
    // verticalArrangement = Arrangement.Center,
     horizontalAlignment = Alignment.CenterHorizontally
 ){
Text(
    text = "Bienvenido",
    fontSize = 35.sp,
    color= Color.Blue
)
     TextField(value =myText , onValueChange ={myText=it},
         placeholder = {
             Text(text = "Escribe tu nombre")
         },
         label = {
             Text(text = "Nombre")
         }
     )

     Espacio(size = 80)

     OutlinedTextField(value = myText, onValueChange = {myText=it},
         label = {
             Text(text = "Nombre")
         }
         )

     Text(
         text=myText
     )
     var context= LocalContext.current
     Button(onClick = {
         Toast.makeText(context,myText,Toast.LENGTH_SHORT).show()
     }) {
         Text(text = "Dar Clic")
     }
 }
}
@Composable
fun Espacio(size:Int){
    Spacer(
        modifier =Modifier.width(size.dp))
}
@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    EstadosTextFieldTheme {
        Pantalla()
    }
}