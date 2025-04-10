package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.bmiCalculator
import br.senai.sp.jandira.bmi.screens.components.BmiLevels
import java.util.Locale

@Composable
fun BMIResultScreen(controleDeNavegacao: NavHostController?) {

    // Obtendo o contexto da tela atual
    val context = LocalContext.current
    // Abrir ou criar um arquivo SharedPreferences
    val userFile = context
        .getSharedPreferences(
            "user_file", Context.MODE_PRIVATE
        )

    val userAge = userFile.getInt("user_age", 0)
    val userWeight = userFile.getInt("user_weight", 0)
    val userHeight = userFile.getInt("user_height", 0)

    val resultBmi = bmiCalculator(userWeight, userHeight.toDouble())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                listOf(
                    Color(0xFFEA9665),
                    Color(0xFFE0E0E0),
                )
            ))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 40.dp, horizontal = 40.dp),
                text = stringResource(R.string.bmi),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(6f),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 25.dp)
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                            modifier = Modifier
                                .size(120.dp)
                                .border(7.dp, resultBmi.color, CircleShape)
                                .clip(CircleShape),
                    )
                    {
                        val bmiValue = resultBmi.bmiValues.second
                        Text(
                            modifier = Modifier
                                .align(alignment = Alignment.Center),
                            text = String.format(Locale.getDefault(), "%.1f", bmiValue),
                            color = Color.Black,
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = stringResource(R.string.youhave),
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                            .height(80.dp),
                        colors = CardDefaults.cardColors(Color(0x5956351D))
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ){
                                Text(
                                    text = stringResource(R.string.age),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W400
                                )
                                Text(text = userAge.toString(),
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold)
                            }
                            VerticalDivider()
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()){
                                Text(
                                    text = stringResource(R.string.weight),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W400
                                )
                                Text(text = "$userWeight kg",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold)
                            }
                            VerticalDivider()
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()){
                                Text(
                                    text = stringResource(R.string.height),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W400
                                )
                                Text(text = userHeight.toString(),
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold)
                            }

                        }
                    }
                    Column(
                        modifier = Modifier
                            .height(250.dp))
                    {
                        BmiLevels()
                        BmiLevels()
                        BmiLevels()
                        BmiLevels()
                        BmiLevels()
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .padding(vertical = 30.dp)
                    )
                    Button(
                        onClick = {
                            controleDeNavegacao!!.navigate("user_data")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5845F)
                        )
                    ) {
                        Text(
                            stringResource(R.string.newcalc),
                            fontSize = 26.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ResultScreenPreview () {
    BMIResultScreen(null)
}