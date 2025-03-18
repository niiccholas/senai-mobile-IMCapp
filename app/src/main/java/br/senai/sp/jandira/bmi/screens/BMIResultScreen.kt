package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun ResultScreen(modifier: Modifier = Modifier){
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
                                .border(7.dp, Color(0xFF8AE886), CircleShape)
                                .clip(CircleShape),
                    ){
                        Text(
                            modifier = Modifier
                                .align(alignment = Alignment.Center),
                            text = stringResource(R.string.test),
                            color = Color.Black,
                            fontSize = 50.sp,
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
                            .height(90.dp),
                        colors = CardDefaults.cardColors(Color(0x5956351D))
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
//                                .padding(horizontal = 40.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween
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
                                Text(text = "50",
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
                                Text(text = "97 Kg",
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
                                Text(text = "178 cm",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold)
                            }

                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(200.dp))
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(vertical = 30.dp)
                    )
                    Button(
                        onClick = {},
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
    ResultScreen()
}