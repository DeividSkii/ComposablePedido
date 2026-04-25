package com.example.myapplication
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Define o conteúdo da tela como a nossa função Composable
            // Substituindo setContentView(R.layout.activity_main)

        }
    }
}


// 2. A UI DECLARATIVA: Onde a UI é uma Função do Estado (UI = F(State))

val poppins = FontFamily(
    Font(resId=R.font.poppins_regular, weight=FontWeight.Normal),
    Font(resId=R.font.poppins_medium, weight=FontWeight.Medium)
)

@Composable
fun ItemPedido(item: String, preco: Double, drawable_id: Int, descricao: String, quantidade: Int) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(drawable_id),
            contentDescription = "Prato ${item}",
            modifier = Modifier.size(100.dp).padding(start = 30.dp)
        )
        Column (modifier = Modifier.padding(start = 20.dp, top = 10.dp).weight(1f)) {
            Text(
                text = item,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = poppins
            )
            Text(
                text = descricao,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                fontFamily = poppins

            )
        }
        Column (modifier = Modifier.padding(start = 30.dp, top = 10.dp)){
            Text(
                text = "R$ $preco",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = poppins
            )
            Row(
                modifier = Modifier
            ) {
                Button(onClick = {}, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(24.dp)) {
                    Image(
                        painter = painterResource(R.drawable.reduzir),
                        contentDescription = "Reduzir",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = quantidade.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Button(onClick = {}, contentPadding = PaddingValues(all = 0.dp), modifier = Modifier.size(24.dp)) {
                    Image(
                        painter = painterResource(R.drawable.somar),
                        contentDescription = "Prato ${item}",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemPedidoPreview(){
    ItemPedido("Macarrão", 7.99, drawable_id = R.drawable.macarrao, "Macarrão com molho de tomate", 1)
}


