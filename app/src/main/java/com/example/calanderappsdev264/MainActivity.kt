package com.example.calanderappsdev264

import android.graphics.Paint.Align
import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import java.util.*
import java.text.SimpleDateFormat
import com.example.calanderappsdev264.ui.theme.CalanderAppSDEV264Theme
import com.example.calanderappsdev264.ui.theme.Purple40
import kotlinx.coroutines.delay
import kotlin.math.log
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import com.example.calanderappsdev264.ui.theme.PurpleGrey40

// 2024-11-14
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalanderAppSDEV264Theme {
                val currentDay = DaysOfWeek[0]
                val currentTime = "1"
                val currentDate = "November"
                val currentMonth = 11
                Column {
                    CurrentTimeScreen()
                    Spacer(modifier = Modifier.height(20.dp))
                    CalandarNav(currentDay, currentDate, currentTime, currentMonth)
                }
                }
            }
        }
    }

// list to hold the differnt days of the year and days of week
val MonthsOfYear = listOf("JANUARY", "FEBUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER"," NOVEMBER", "DECEMBER")
val DaysOfWeek = listOf("Sunday", "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday")


@Composable
fun CurrentTimeScreen() {

    val currentDate = remember { mutableStateOf("")}
    val currentTime = remember { mutableStateOf("")}

    LaunchedEffect(Unit) {
        while (true) {
            // Get current date and time using Calendar
            val calendar = Calendar.getInstance()
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val time = SimpleDateFormat("HH:mm:ss")
            val formattedDate = sdf.format(calendar.time)
            val formattedTime = time.format(calendar.time)

            currentDate.value = formattedDate
            currentTime.value = formattedTime

            delay(1000)
        }
    }
    // Layout to show the time
    Column(
        modifier = Modifier
            .background(PurpleGrey40)
            .border(6.dp, Color.DarkGray)
    ) {
        Text(
            "Calandar App",
            modifier = Modifier
                .padding(30.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 25.sp),
        )

        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(0.dp, 30.dp)
                .fillMaxWidth()
                .height(50.dp),

            ) {
            Text(
                text = currentDate.value,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(25.dp, 0.dp),
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center
            )
            Text(
                text = currentTime.value,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp, 0.dp),
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center
            )
            Button(
                //Make a navigation to the setting menu page
                onClick = {},
                modifier = Modifier
                    .size(100.dp)
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "button that lets users add events on specific days",
                    modifier = Modifier
                        .fillMaxSize()
                        .size(90.dp),
                    Color.Black
                )

            }
        }
    }
}




// Function that shows the differnt times for a certain day and allow the user to add different events for specific times
@Composable
fun CalandarNav(
    currentDay: String,
    currentDate: String,
    currentTime: String,
    currentMonth: Int
) {
    val daysInMonth = LocalDate.now()
        .withMonth(currentMonth)
        .lengthOfMonth()

    // Get the first day of the current month
    val firstDayOfMonth = LocalDate.now()
        .withMonth(currentMonth)
        .withDayOfMonth(1)

    // Get the day of the week for the 1st of the month (Sunday = 7, Saturday = 6, etc.)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value // This returns 1 for Monday, 7 for Sunday

    // Create a list to hold day numbers (for rendering)
    val daysList = (1..daysInMonth).toList()
    // Wrap the content in a LazyColumn to make it scrollable
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Use 'items' with the correct list (daysList)
        itemsIndexed(daysList) { index, day ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp) // Add spacing between items
            ) {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .background(Purple40)
                        .fillMaxWidth()
                        .padding(20.dp, 15.dp)
                ) {
                    Button(
                        //Navigate to the page that allows the user to add events to specific date
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(100.dp),
                        contentPadding = PaddingValues(0.dp),


                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "button that lets users add events on specific days",
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxSize()
                                .size(70.dp),
                            Color.Black
                        )
                    }
                    Text(
                        "Day $day",
                        style = TextStyle(fontSize = 30.sp),
                        color = Color.Black
                    )
                    Text(
                        "November",
                        modifier = Modifier
                            .align(Alignment.BottomEnd),
                        style = TextStyle(fontSize = 35.sp),
                        color = Color.Black,
                    )
                }
            }
        }
    }
}
