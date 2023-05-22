package edu.towson.cosc435.meegan.finalpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.towson.cosc435.meegan.finalpractice.ui.theme.FinalPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    columnText()
//                    lazyColumn()
                      DisplayButton()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalPracticeTheme {
        Greeting("Android")
    }
}

//This makes a text in a column

@Composable
fun columnText() {
    Column {
        Text(text = "hello")
        Text(text = "MF")
    }
}

@Composable
fun lazyColumn() {
    val itemsList = listOf("Item 1", "Item 2", "Item 3", "Item 4")

    LazyColumn {
        items(items = itemsList) {item ->
            Text(text = item)
        }
    }
}

@Composable
fun DisplayButton() {
    Button(onClick = { Log.d("DisplayButton", "Button Clicked!") }) {
        Text("Click Me!")
    }
}

class ExampleViewModel : ViewModel() {
    val count = MutableLiveData(0)

    fun increment() {
        count.value = count.value?.plus(1)
    }


}

@Composable
fun DisplayViewModel() {
    val viewModel = viewModel<ExampleViewModel>()
    val count by viewModel.count.observeAsState()

    Button(onClick = { viewModel.increment() } ) {
        Text("you have cliked the button $count times")
    }
}