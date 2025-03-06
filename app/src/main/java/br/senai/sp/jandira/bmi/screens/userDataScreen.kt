package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun Datascreen(modifier: Modifier = Modifier){

    var ageState = remember {
        mutableStateOf(value = "")
    }
    var weightState = remember {
        mutableStateOf(value = "")
    }
    var heightState = remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBD6C35))
    ){
        Column{
            Text(
                modifier = Modifier
                    ,
                text = stringResource(R.string.hi),
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DatascreenPreview () {
    Datascreen()
}