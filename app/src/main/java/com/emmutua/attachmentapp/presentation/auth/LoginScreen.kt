package com.emmutua.attachmentapp.presentation.auth

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.emmutua.attachmentapp.utils.MyOutlinedTextField
import com.emmutua.attachmentapp.utils.PassWordField
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.rememberMessageBarState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    registerState: AuthStateData,
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val passwordVisible by rememberSaveable { mutableStateOf(false) }
    val isLoading = registerState.isLoading
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
    ) {
        val messageBarState = rememberMessageBarState()
        ContentWithMessageBar(messageBarState = messageBarState) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Welcome Back!",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(50.dp))

                MyOutlinedTextField(
                    value = email,
                    placeHolder = "Email",
                    onValueChange = { email = it },
                    isError = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                    ),
                )
                Spacer(modifier = Modifier.height(10.dp))

                PassWordField(
                    isPasswordVisible = passwordVisible,
                    passwordValue = password,
                    label = "Password",
                    isError = false,
                    onValueChange = { password = it },
                )

                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {
                        if (email == "" || password == "") {
                            Toast.makeText(context, "All fields required", Toast.LENGTH_SHORT)
                                .show()
                            return@Button
                        }
                        viewModel.signInEmailAndPassword(email, password) {
                            if (registerState.isSignedIn) {
                                Toast.makeText(context, registerState.message, Toast.LENGTH_SHORT)
                                    .show()
                                navigateToHome()
                            } else {
                                Toast.makeText(context, registerState.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    },
                    shape = RoundedCornerShape(16),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                ) {
                    if (!isLoading) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = "Login",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                        )
                    } else {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
                TextButton(
                    onClick = {
                        navigateToRegister()
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(),
                            ) {
                                append("No Account?")
                            }
                            append(" ")
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                ),
                            ) {
                                append("Register")
                            }
                        },
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
