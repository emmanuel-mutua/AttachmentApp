package com.emmutua.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.emmutua.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField(
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(text = placeHolder)
        },
        keyboardOptions = keyboardOptions,
        isError = isError,
    )
    Spacer(modifier = Modifier.height(5.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassWordField(
    isPasswordVisible: Boolean,
    passwordValue: String,
    label: String,
    onValueChange: (String) -> Unit,
    isError: Boolean
) {
    var passwordVisible by rememberSaveable { mutableStateOf(isPasswordVisible) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordValue,
        onValueChange = {
            onValueChange(it)
        },
        singleLine = true
        ,
        label = { Text(label) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        isError = isError,
        trailingIcon = {
            val imageResource = if (passwordVisible) {
                R.drawable.baseline_visibility_24
            } else {
                R.drawable.baseline_visibility_off_24
            }
            // Localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            // Toggle button to hide or display password
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = painterResource(id = imageResource), contentDescription = "")
            }
        },
    )
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun MyProgressIndicator() {
    Column {
        CircularProgressIndicator()
    }
}
