package com.example.labo8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFBFBF9)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier,
                imageVector = androidx.compose.material.icons.Icons.Default.Home,
                contentDescription = "Home"
            )
            Text(
                modifier = Modifier,
                text = "Today"
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier,
                imageVector = androidx.compose.material.icons.Icons.Default.DateRange,
                contentDescription = "Home"
            )
            Text(
                modifier = Modifier,
                text = "Upcoming"
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier,
                imageVector = androidx.compose.material.icons.Icons.Default.Search,
                contentDescription = "Home"
            )
            Text(
                modifier = Modifier,
                text = "Search"
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Icon(
                modifier = Modifier,
                imageVector = androidx.compose.material.icons.Icons.Default.List,
                contentDescription = "Home"
            )
            Text(
                modifier = Modifier,
                text = "Browse"
            )
        }
    }
}