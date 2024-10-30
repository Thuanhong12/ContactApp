package com.example.contactapp

import android.telephony.UiccCardInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun CardInfo(name: String, phone: String, onClickCard:()-> Unit){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        onClick = onClickCard
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(2f)){
                Box(modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color = Color.LightGray),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text =name[0].toString().uppercase(),
                        fontWeight = FontWeight.Bold,
                        color=Color.Blue
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = phone,
                        color = Color.Gray
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}