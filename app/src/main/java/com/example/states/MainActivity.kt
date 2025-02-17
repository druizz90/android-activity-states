package com.example.states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.states.ui.theme.StatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TeamsLayout()
                }
            }
        }
    }
}

@Composable
fun TeamsLayout() {
    var teamIndex by remember { mutableIntStateOf(0) }
    var teamIds = arrayListOf<String>("granada_cf", "granada_recreativo")
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        TeamResources(teamIds[teamIndex])
        Buttons(teamIndex, teamIds.size, { newIndex -> teamIndex = newIndex })
    }
}

@Composable
fun TeamResources(teamId: String) {
    var (teamShieldRef, teamTitle, teamSubtitle )= when (teamId) {
        "granada_recreativo" -> Triple(R.drawable.granada_recreativo, R.string.recreativo_title, R.string.recreativo_subtitle)
        else -> Triple(R.drawable.granada_cf, R.string.granada_cf_title, R.string.granada_cf_subtitle)
    }
    Image(
        painter = painterResource(teamShieldRef),
        contentDescription = "",
        modifier = Modifier.size(300.dp))
    Spacer(modifier = Modifier.height(32.dp))
    Column (
        modifier = Modifier.background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(teamTitle))
        Text(text = stringResource(teamSubtitle))
    }
    Spacer(modifier = Modifier.height(32.dp))
}

internal fun calculatePreviousIndex(index: Int, size: Int): Int {
    return (index - 1 + size) % size
}

internal fun calculateNextIndex(index: Int, size: Int): Int {
    return (index + 1) % size
}

@Composable
fun Buttons(teamIndex: Int, teamsSize: Int, onStepChange: (Int) -> Unit)  {
    val previous = calculatePreviousIndex(teamIndex, teamsSize)
    val next = calculateNextIndex(teamIndex, teamsSize)
    Row {
        Button(onClick = { onStepChange(previous) }, modifier = Modifier.padding(12.dp)) {
            Text(text = "Previous")
        }
        Button(onClick = { onStepChange(next) }, modifier = Modifier.padding(12.dp)) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StatesTheme {
        TeamsLayout()
    }
}