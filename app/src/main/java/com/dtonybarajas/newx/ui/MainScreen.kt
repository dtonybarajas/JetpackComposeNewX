package com.dtonybarajas.newx.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dtonybarajas.newx.R

@Composable
fun MainScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Color(0xFF161D26))
    ) {
        ProfilePicture()
        TwitCard()
    }
}

@Composable
fun TwitCard() {
    Column(
        modifier = Modifier.padding(start = 8.dp, end = 32.dp)
    ) {
        UserTitle()
        TextContent()
        ImageContent()
        Buttons()
    }
}

@Composable
fun Buttons() {

    var chat by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "chat"
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat_filled),
                    contentDescription = "chat",
                    tint = Color(0xFF7E8B98)
                )
            },
            isSelected = chat
        ) { chat = !chat }

        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "chat"
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "chat",
                    tint = Color.Green
                )
            },
            isSelected = rt
        ) { rt = !rt }

        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "chat"
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_filled),
                    contentDescription = "chat",
                    tint = Color.Red
                )
            },
            isSelected = like
        ) { like = !like }
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {

    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color.Gray,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun ImageContent() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Picture Twit",
        modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
    )
}

@Composable
fun TextContent() {
    Text(
        text = LoremIpsum(25).values.first(),
        color = Color.White,
    )
}

@Composable
fun UserTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Tony ", fontWeight = FontWeight.Bold, color = Color.White
        )
        Text(
            text = "@dtonybarajas 4h",
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "More",
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Composable
fun ProfilePicture() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile picture",
        modifier = Modifier
            .padding(16.dp)
            .size(64.dp)
            .clip(CircleShape)
    )
}
