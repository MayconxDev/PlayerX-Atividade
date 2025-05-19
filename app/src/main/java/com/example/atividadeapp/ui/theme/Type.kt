package com.example.atividadeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.atividadeapp.R

// ✅ Primeiro declare a fonte personalizada
val exo2FontFamily = FontFamily(
    Font(R.font.exo_2_extrabold, FontWeight.ExtraBold)
)

// ✅ Depois crie a Typography usando a fonte
val Typography = Typography(
    bodyLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = exo2FontFamily,
        color = Color.White // ou MaterialTheme.colorScheme.onBackground
    )
)
    val fontzada = FontFamily(
        Font( R.font.port_lligat_slab, FontWeight.Normal)
        )