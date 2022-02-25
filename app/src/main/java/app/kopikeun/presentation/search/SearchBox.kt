package app.kopikeun.presentation.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchBox(
    query: TextFieldValue,
    focusRequester: FocusRequester,
    onQueryChange: (TextFieldValue) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
) {
    Surface(
        elevation = 2.dp,
        modifier = modifier.fillMaxWidth(),
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            singleLine = true,
            shape = RectangleShape,
            placeholder = {
                if (placeholder.isNotEmpty())
                    Text(text = placeholder)
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
            ),
            leadingIcon = {
                IconButton(
                    onClick = onBackPressed,
                    content = {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                )
            },
            trailingIcon = {
                if (query.text.isNotEmpty())
                    IconButton(
                        onClick = { onQueryChange(TextFieldValue(text = "")) },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear",
                            )
                        }
                    )
            },
            modifier = Modifier.focusRequester(focusRequester),
        )
    }
}