package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.material.Text as Text1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Operation()
        }
    }
}
@Composable
fun Operation(){
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    var textFieldState1 by remember {
        mutableStateOf("")
    }
    var textFieldState2 by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Text1(
                text = "Calculator",
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = textFieldState,
                label = {
                    Text1(text = "Enter the first number")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = textFieldState1,
                label = {
                    Text1(text = "Enter the second number")
                },
                onValueChange = {
                    textFieldState1 = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = textFieldState2,
                label = {
                    Text1(text = "Enter any one operation from(+,-,*,/)")
                },
                onValueChange = {
                    textFieldState2 = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    val answer: Int
                    if (textFieldState2.equals("+")) {
                        answer = (Integer.parseInt(textFieldState) + Integer.parseInt(
                            textFieldState1
                        ))
                        scaffoldState.snackbarHostState.showSnackbar("$answer")
                    } else if (textFieldState2.equals("-")) {
                        answer = (Integer.parseInt(textFieldState) - Integer.parseInt(
                            textFieldState1
                        ))
                        scaffoldState.snackbarHostState.showSnackbar("$answer")
                    } else if (textFieldState2.equals("*")) {
                        answer = (Integer.parseInt(textFieldState) * Integer.parseInt(
                            textFieldState1
                        ))
                        scaffoldState.snackbarHostState.showSnackbar("$answer")
                    } else {
                        if (textFieldState1.equals("0")) {
                            answer = 0
                            scaffoldState.snackbarHostState.showSnackbar("Division by 0")
                        } else {
                            answer = (Integer.parseInt(textFieldState) / Integer.parseInt(
                                textFieldState1
                            ))
                            scaffoldState.snackbarHostState.showSnackbar("$answer")
                        }
                    }

                }
            }) {
                Text1(text = "Submit")
            }
        }
    }
}
//@Composable
//fun DropDown(
//    text:String,
//    modifier: Modifier=Modifier,
//    initiallyOpened: Boolean=false,
//    content: @Composable () -> Unit
//){
//    var isOpen by remember {
//        mutableStateOf(initiallyOpened)
//    }
//    val alpha= animateFloatAsState(
//        targetValue = if(isOpen) 1f else 0f,
//        animationSpec = tween(
//            durationMillis = 300
//        )
//    )
//    val rotateX= animateFloatAsState(
//        targetValue = if(isOpen) 0f else -90f,
//        animationSpec = tween(
//            durationMillis = 300
//        )
//    )
//    Column(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Row (
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier.fillMaxWidth()
//        ){
//            Text1(
//                text = text,
//                color = Color.White,
//                fontSize = 16.sp
//            )
//            Icon(
//                imageVector = Icons.Default.ArrowDropDown,
//                contentDescription = "Open Or Close Drop Down",
//                tint = Color.White,
//
//            )
//        }
//    }
//}