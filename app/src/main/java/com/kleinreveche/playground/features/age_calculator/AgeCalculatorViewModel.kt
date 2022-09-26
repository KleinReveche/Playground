package com.kleinreveche.playground.features.age_calculator

import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.kleinreveche.playground.R
import java.text.SimpleDateFormat
import java.util.*

class AgeCalculatorViewModel {

    private val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
    private val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
    private val currentDateInMinutes = currentDate?.time?.div(60000)
    private val defaultDateInMinutes = currentDateInMinutes?.minus(17723520)
    private val defaultDateInHours = defaultDateInMinutes?.div(60)
    private val defaultDateInDays = defaultDateInHours?.div(24)

    var selectedDate by mutableStateOf ( "09/13/2003" )
    var selectedDateInMinutes by mutableStateOf ( defaultDateInMinutes.toString() )
    var selectedDateInHours by mutableStateOf ( defaultDateInHours.toString() )
    var selectedDateInDays by mutableStateOf ( defaultDateInDays.toString() )

    fun showDatePicker(context: Context) {

        val myCalendar = Calendar.getInstance()
        val currentYear = myCalendar.get(Calendar.YEAR)
        val currentMonth = myCalendar.get(Calendar.MONTH)
        val currentDay = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, SelectedDay ->

                val selectedDateInPickerFormatted= "0${selectedMonth + 1}/$SelectedDay/$selectedYear"

                val theDate = sdf.parse(selectedDateInPickerFormatted)

                theDate?.let {
                    val selectedDateInMinutesInPicker = theDate.time / 60000

                    currentDate?.let {

                        val differenceInMinutes = currentDateInMinutes?.minus(selectedDateInMinutesInPicker)
                        val selectedDateInHoursInPicker = differenceInMinutes?.div(60)
                        val selectedDateInDaysInPicker = selectedDateInHoursInPicker?.div(24)

                        this.selectedDate = selectedDateInPickerFormatted
                        this.selectedDateInMinutes = differenceInMinutes.toString()
                        this.selectedDateInHours = selectedDateInHoursInPicker.toString()
                        this.selectedDateInDays = selectedDateInDaysInPicker.toString()
                    }
                }

            },
            currentYear,
            currentMonth,
            currentDay
        )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }


    fun showNewDatePicker() {
        val calendar = Calendar.getInstance()
        val endDate = currentDate!!.time.minus(86400000)
        val calendarConstraintBuilder =
            CalendarConstraints.Builder().setOpenAt(endDate).setEnd(endDate)
        val validators = ArrayList<CalendarConstraints.DateValidator>()
        validators.add(DateValidatorPointBackward.before(endDate))
        calendarConstraintBuilder.setValidator(CompositeDateValidator.allOf(validators))

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(R.string.app_calc_datepicker_title)
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setCalendarConstraints(calendarConstraintBuilder.build())
            .build()

        datePicker.addOnPositiveButtonClickListener {
            calendar.timeInMillis = it
            val selectedDateInPicker = sdf.parse(sdf.format(datePicker.selection))

            currentDate.let {
                val selectedDateInMinutes = selectedDateInPicker?.time?.div(60000)

                val differenceInMinutes =
                    currentDateInMinutes?.minus(selectedDateInMinutes!!)
                val selectedDateInHours =
                    differenceInMinutes?.div(60)
                val selectedDateInDays =
                    selectedDateInHours?.div(24)

                val selectedDateFormatted = sdf.format(selectedDate).toString()

                selectedDate = selectedDateFormatted
                this.selectedDateInMinutes = differenceInMinutes.toString()
                this.selectedDateInHours = selectedDateInHours.toString()
                this.selectedDateInDays = selectedDateInDays.toString()

            }

        //datePicker.show(supportFragmentManager, "date_picker") 

        }

    }
}
