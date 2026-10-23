package com.example.lab_07

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        //back button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        //title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        //text field and add button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driver,
                onValueChange = { driver = it },
                label = { Text("Driver Name") },
                modifier = Modifier.testTag("driverInput")
            )

            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        drivers.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriver")
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //clear all button
        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearDrivers")
        ) {
            Text("Clear All")
        }

        //list of drivers
        LazyColumn {
            items(drivers) { name ->
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = name,
                    fontSize = 24.sp
                )
            }
        }
    }
}