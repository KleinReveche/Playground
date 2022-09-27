package com.kleinreveche.playground.features.age_calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kleinreveche.playground.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgeCalculator(){
    val context = LocalContext.current
    val ageCalculatorViewModel = AgeCalculatorViewModel()
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.ic_bg),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
        ) { it.calculateBottomPadding()
            ElevatedCard(
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = stringResource(R.string.age_calc),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    ) //Tile
                    Spacer(modifier = Modifier.height(25.dp))
                    Button(
                        onClick = { ageCalculatorViewModel.showDatePicker(context = context) }
                    ){
                        Text(
                            text = stringResource(R.string.app_calc_datepicker_title),
                            fontSize = 18.sp
                        )
                    } //DatePicker
                    Spacer(modifier = Modifier.height(20.dp))
                    Text( 
                        text = ageCalculatorViewModel.selectedDate,
                        color = MaterialTheme.colorScheme.primary,                             
                        fontSize = 20.sp
                    )  //selectedDate
                    Text( 
                        text = stringResource(R.string.age_calc_selected_date),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 18.sp
                    ) //selectedDateLabel
                    Spacer(modifier = Modifier.height(20.dp))
                    Text( 
                        text = ageCalculatorViewModel.selectedDateInMinutes,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 35.sp
                     )  //ageInMinutesDate
                    Text( 
                        text = stringResource(R.string.age_in_minutes),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 18.sp
                     ) //ageInMinutesDateLabel
                    Spacer(modifier = Modifier.height(20.dp))
                    Text( 
                         text = ageCalculatorViewModel.selectedDateInHours,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 35.sp
                    )  //ageInHoursDate
                    Text( 
                        text = stringResource(R.string.age_in_hours),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 18.sp
                    ) //ageInHoursDateLabel
                    Spacer(modifier = Modifier.height(20.dp))
                    Text( 
                         text = ageCalculatorViewModel.selectedDateInDays,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 35.sp
                    )  //ageInDaysDate
                    Text( 
                        text = stringResource(R.string.age_in_days),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 18.sp
                     ) //ageInDaysDateLabel
                }
            }
        }
    }
}

const val AgeCalculatorComposeFeatureRoute = "ageCalculatorCompose"

@Preview(showBackground = true)
@Composable
fun AgeCalculatorPreview(){
    AgeCalculator()
}
