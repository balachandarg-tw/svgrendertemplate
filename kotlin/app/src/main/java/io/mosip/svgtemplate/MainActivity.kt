package io.mosip.svgtemplate

import SvgRenderingTemplate
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.mosip.svgtemplate.ui.theme.SvgtemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SvgtemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val svgTemplate = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"250\" height=\"400\" viewBox=\"0 0 250 400\">\n" +
            "<text x=\"20\" y=\"60\" fill = \"#0000ff\" font-size=\"18\" font-weight=\"bold\">Hi {{user/name}}</text>\n" +
            "</svg>";
    Column() {
        Text(
            text = "Hello $svgTemplate!",
            modifier = modifier
        )
        Button(onClick = {
            val replacedTemplate = SvgRenderingTemplate().replaceSVGTemplatePlaceholders(svgTemplate, mapOf("user" to mapOf("name" to "John Doet")))
            System.out.print("---->$replacedTemplate")
        }) {
            Text(text = "Replace")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SvgtemplateTheme {
        Greeting("Android")
    }
}