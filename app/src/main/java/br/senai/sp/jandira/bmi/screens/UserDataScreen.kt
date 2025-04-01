package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Numbers
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun Datascreen(controleDeNavegacao: NavHostController?) {

    var ageState = remember {
        mutableStateOf(value = "")
    }
    var weightState = remember {
        mutableStateOf(value = "")
    }
    var heightState = remember {
        mutableStateOf(value = "")
    }
    var selectedColorState = remember {
        mutableStateOf(Color(0xFFF85A00))
    }
    var notSelectedColorState = remember {
        mutableStateOf(Color(0xD5D2A385))
    }
    var isMaleClicked = remember {
        mutableStateOf(false)
    }
    var isFemaleClicked = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)

    val userName = userFile.getString("user_name", "User not found")

    // Criamos um editor responsável por editar o arquivo
    val editor = userFile.edit()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEA9665))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 40.dp, horizontal = 40.dp),
                text = "${stringResource(R.string.hi)}, $userName!",
                color = Color.White,
                fontSize = 30.sp
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(4f),
                shape = RoundedCornerShape(topStart = 43.dp, topEnd = 43.dp),

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .border(2.dp, brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFFD0BF80), Color(0xFFE79541))

                                ), CircleShape)
                                    .clip(CircleShape),
                            ){
                                Image(
                                    modifier = Modifier
                                        .align(alignment = Alignment.Center)
                                        .size(100.dp)
                                        .padding(end = 8.dp),
                                    painter = painterResource(R.drawable.male),
                                    contentDescription = ("Male"),
                                )
                            }
                            Button(
                                onClick = {
                                    isMaleClicked.value = true
                                    isFemaleClicked.value = false
                                },
                                modifier = Modifier
                                    .width(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if(isMaleClicked.value) selectedColorState.value else notSelectedColorState.value
                                )
                            ) {
                                Text(stringResource(R.string.male))
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .border(2.dp, brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFFD0BF80), Color(0xFFE79541))

                                    ), CircleShape)
                                    .clip(CircleShape)){
                                Image(
                                    modifier = Modifier
                                        .align(alignment = Alignment.Center)
                                        .size(100.dp),
                                    painter = painterResource(R.drawable.female),
                                    contentDescription = ("female")
                                )
                            }
                            Button(
                                onClick = {
                                    isFemaleClicked.value = true
                                    isMaleClicked.value = false
                                },
                                modifier = Modifier
                                    .width(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if(isFemaleClicked.value) selectedColorState.value else notSelectedColorState.value
                                )
                            ) {
                                Text(stringResource(R.string.female))
                            }
                        }
                    }
                    Column {
                        OutlinedTextField(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },


                            label = {
                                Text(
                                    text = stringResource(R.string.age)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFFDE844B)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },


                            label = {
                                Text(
                                    text = stringResource(R.string.weight)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFFDE844B)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.height)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowUpward,
                                    contentDescription = "",
                                    tint = Color(0xFFD98A5A)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                    Button(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5845F)
                        ),
                        onClick = {
                            editor.putInt("user_age", ageState.value.toInt())
                            editor.putInt("user_weight", weightState.value.toInt())
                            editor.putInt("user_height", heightState.value.toInt())
                            editor.apply()
                            controleDeNavegacao!!.navigate("bmi_result")
                        },
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = stringResource(R.string.calculate),
                            style = TextStyle(fontSize = 23.sp))
                    }
                }
            }
        }
    }
}//mmsiam

@Preview(showSystemUi = true)
@Composable
private fun DatascreenPreview () {
    Datascreen(null)
}