package com.kleinreveche.playground.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.kleinreveche.playground.isLight

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val PrimaryLight = Color(0xff005AC1)
val SecondaryLight = Color(0xff006E1D)
val TertiaryLight = Color(0xff715573)

val PrimaryDark = Color(0xffADC6FF)
val SecondaryDark = Color(0xff74DD75)
val TertiaryDark = Color(0xffDEBCDF)

val RedOrange = Color(0xffffab91)
val RedPink = Color(0xfff48fb1)
val BabyBlue = Color(0xff81deea)
val Violet = Color(0xffcf94da)
val LightGreen = Color(0xffe7ed9b)


val androidGreen = Color(0xFF3DDC84)
val navy = Color(0xFF073042)
val purplish = Color(0xFF880E4F)
val lightBlue = Color(0xFFE0F7FA)

object Colors {

    private val ballShadowColorDark = Color.Black.copy(alpha = 0.3f)
    private val ballShadowColorLight = Color.Black.copy(alpha = 0.1f)
    private val systemBarsScrim = Color(0x80000000)

    val systemBars @Composable get() = systemBarsScrim.compositeOver(MaterialTheme.colorScheme.background)

    val ballShadow @Composable get() = if (MaterialTheme.colorScheme.isLight()) ballShadowColorLight else ballShadowColorDark
}