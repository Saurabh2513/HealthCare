package com.example.ticket_booking_app.ui.theme.activity.slpash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ticket_booking_app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
@Preview
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
            val (backgroundImg, title, subtitle, startbtn) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.splash_bg),
                contentDescription = null,
                modifier = Modifier.constrainAs(backgroundImg){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            val styledText = buildAnnotatedString {
                append("Discover your \n Dream")
                withStyle(style = SpanStyle(color = colorResource(R.color.orange))){
                    append(" Flight")
                }
                append("\nEasily")
            }
            Text(
                text = styledText,
                fontSize = 53.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 32.dp)
                    .padding(horizontal = 16.dp)
                    .constrainAs(title){
                        top.linkTo(parent.top)
                            start.linkTo(parent.start)

                    }
            )
        }
    }
}