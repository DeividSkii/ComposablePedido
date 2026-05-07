package com.example.myapplication
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

class ProdutoViewModel : ViewModel() {

    var quantidade by mutableStateOf(1)
        private set

    var nomeProduto by mutableStateOf("")
        private set

    var codigoPdv by mutableStateOf("")
        private set

    var preco by mutableStateOf("")
        private set



    fun aumentarQuantidade() {
        quantidade++
    }

    fun diminuirQuantidade() {
        if (quantidade > 1) {
            quantidade--
        }
    }

    fun atualizarNomeProduto(novoNome: String) {
        nomeProduto = novoNome
    }

    fun atualizarCodigoPdv(novoCodigo: String) {
        codigoPdv = novoCodigo
    }

    fun atualizarPreco(novoPreco: String) {
        preco = novoPreco
    }

}



val poppins = FontFamily(
    Font(resId=R.font.poppins_regular, weight=FontWeight.Normal),
    Font(resId=R.font.poppins_medium, weight=FontWeight.Medium)
)

@Composable
fun CreateTextField(
    valor: String,
    aoMudar: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
){
    TextField(
        value = valor,
        onValueChange = aoMudar,
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = poppins
            )
        },
        modifier = modifier
            .width(332.dp)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFDD0B5),
            unfocusedContainerColor = Color(0xFFFDD0B5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 14.sp,
            fontFamily = poppins
        )
    )
}
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

@Composable
fun PratoEspecial(item: String, preco: Double, ImageUrl: String, descricao: String){
    Box(modifier = Modifier.height(300.dp).width(200.dp)){

        Box(
            modifier = Modifier
                .height(240.dp)
                .width(190.dp)
                .align(Alignment.BottomStart)
                .padding(start = 25.dp, bottom = 10.dp)
                .background(Color(0xFFFDD0b5), shape = RoundedCornerShape(32.dp))
        ){
            Column(
                modifier = Modifier.padding(top = 110.dp, start = 10.dp)
            ) {
                Text(
                    text = item,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    fontFamily = poppins
                )
                Text(
                    text = "R$ $preco",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    fontFamily = poppins
                )
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    Text(
                        text = "Veja os detalhes",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        fontFamily = poppins
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Button(onClick = {}, contentPadding = PaddingValues(), modifier = Modifier.size(24.dp)) {
                        Image(
                            painter = painterResource(R.drawable.seta),
                            contentDescription = "Prato ${item}",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            }
        }

        AsyncImage(
            model = ImageUrl,
            contentDescription = "Prato ${item}",
            modifier = Modifier
                .padding(end = 50.dp, bottom = 60.dp)
                .size(160.dp),
            placeholder = painterResource(R.drawable.macarrao)
        )
    }



@Composable
fun CadastroDeProduto(
    viewModel: ProdutoViewModel = viewModel(), nomeDoProduto: String, preco: Double, descricao: String, codigoDoPdv: String
) {

    val quantidadeAtual = viewModel.quantidade

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 50.dp)
    ) {

        Text(
            text = "Cadastro de Produto",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            fontFamily = poppins,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        CreateTextField(
            valor = viewModel.nomeProduto,
            aoMudar = { viewModel.atualizarNomeProduto(it) },
            placeholder = "Nome do Produto",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.width(332.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier) {
                CreateTextField(
                    valor = viewModel.preco,
                    aoMudar = { viewModel.atualizarPreco(it) },
                    placeholder = "R$ 0,00",
                    modifier = Modifier.width(170.dp)
                )

                Row(
                    modifier = Modifier
                ) {
                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(24.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.reduzir),
                            contentDescription = "Reduzir",
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Text(
                        text = quantidadeAtual.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        fontFamily = poppins,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(all = 0.dp),
                        modifier = Modifier.size(24.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.somar),
                            contentDescription = "somar",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                    Box(
                        modifier = Modifier
                            .height(100.dp)
                            .width(140.dp)
                            .background(Color(0xFFFDD0B5), shape = RoundedCornerShape(12.dp))
                            .clickable {
                                println("Clicou no botão")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(R.drawable.upload_standard),
                                contentDescription = "Upload",
                                tint = Color.Black,
                                modifier = Modifier.size(32.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Adicione uma foto",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        }
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

@Preview(showBackground = true)
@Composable
fun PratoEspecialPreview(){
    PratoEspecial("Macarrão", 7.99, "https://googleusercontent.com/1vqSlT6Zj7M-JvSWtUC9g5xkoQg01eLcz",  "Macarrão com molho de tomate")
}

@Preview(showBackground = true)
@Composable
fun CadastroDeProdutoPreview(){
    CadastroDeProduto(nomeDoProduto = "Macarrão", preco = 7.99, descricao = "Macarrão com molho de tomate", codigoDoPdv = "123")
}