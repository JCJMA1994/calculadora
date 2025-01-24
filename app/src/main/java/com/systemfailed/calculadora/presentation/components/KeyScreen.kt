package com.systemfailed.calculadora.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KeyScreen(
    number: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE0E0E0),
    colorText: Color = Color.Black,
    textStyle: TextStyle = TextStyle(),
    onclick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable {
                onclick()
            }
            .then(modifier)
    ) {
        Text(
            text = number,
            style = textStyle,
            fontSize = 36.sp,
            color = colorText
        )
    }
}