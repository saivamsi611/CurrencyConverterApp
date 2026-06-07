package com.example.currencyconverter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.currencyconverter.nav.Routes
import com.example.currencyconverter.viewmodel.myviewmodel

@Composable
fun HomeScreen(
    navController: NavController,
    viewmodel: myviewmodel
) {

    var amount by remember {
        mutableStateOf("")
    }

    var base by remember {
        mutableStateOf("USD")
    }

    val getrate = viewmodel.state2.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Currency Converter",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text("Amount")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = base,
            onValueChange = {
                base = it.uppercase()
            },
            label = {
                Text("Base Currency (USD)")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (base.isNotBlank()) {
                    viewmodel.getrates(base)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert")
        }

        Button(
            onClick = {
                if (base.isNotBlank()) {
                    navController.navigate(
                        Routes.ExchangeRoute(base)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View All Rates")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        when {

            getrate.value.loading -> {

                CircularProgressIndicator()
            }

            getrate.value.error != null -> {

                Text(
                    text = getrate.value.error ?: ""
                )
            }

            getrate.value.rates != null -> {

                Text(
                    text = "Conversions for $base",
                    style = MaterialTheme.typography.titleMedium
                )

                LazyColumn {

                    items(
                        getrate.value.rates!!
                    ) { rate ->

                        val enteredAmount =
                            amount.toDoubleOrNull() ?: 0.0

                        val convertedAmount =
                            enteredAmount * rate.rate

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement =
                                    Arrangement.SpaceBetween
                            ) {

                                Column {

                                    Text(
                                        text = "${rate.base} → ${rate.quote}"
                                    )

                                    Text(
                                        text = "Rate: ${rate.rate}"
                                    )

                                    Text(
                                        text = "Date: ${rate.date}"
                                    )
                                }

                                Text(
                                    text = String.format(
                                        "%.2f",
                                        convertedAmount
                                    ),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                }
            }

            else -> {

                Text(
                    text = "Enter amount and currency, then click Convert"
                )
            }
        }
    }
}