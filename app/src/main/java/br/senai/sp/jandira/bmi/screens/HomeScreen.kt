package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun Homescreen(controleDeNavegacao: NavHostController?) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

    // Obtendo o contexto da tela atual
    val context = LocalContext.current
    // Abrir ou criar um arquivo SharedPreferences
    val userFile = context
        .getSharedPreferences(
            "user_file", Context.MODE_PRIVATE
        )

    // Criamos um editor responsável por editar o arquivo
    val editor = userFile.edit()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                listOf(
                    Color(0xFFE0E0E0),
                    Color(0xFFF65B22),
                )
            ))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                modifier = Modifier
                    .padding(vertical = 50.dp),
                painter = painterResource(R.drawable.exercise),
                contentDescription = stringResource(R.string.logo )
            )

            Text(
                modifier = Modifier
                    .padding(bottom = 60.dp),
                text = stringResource(R.string.welcome),//pasta de recursos
                color = Color.White,
                fontSize = 30.sp
            )

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .height(150.dp),
                shape = RoundedCornerShape(topStart = 43.dp, topEnd = 43.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = { it ->
                                nomeState.value = it
                            },
                            label = {
                                Text(text = stringResource(R.string.placeholder))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "",
                                    tint = Color(0xFFC29B81)
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = Color(0xFFA47858)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,

                                capitalization = KeyboardCapitalization.Words
                            )
                        )
                    }


                    Button(
                        onClick = {
                            editor.putString("user_name", nomeState.value)
                            editor.putString("user_city", "Jandira") //variavel, valor
                            editor.apply()
                            controleDeNavegacao!!.navigate("user_data")

                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5845F)
                        ),
                        modifier = Modifier
                            .align(Alignment.End)
                    )
                    {
                        Text(
                            text = stringResource(R.string.next),
                            fontSize = 17.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomescreenPreview () {
    Homescreen(null)
}