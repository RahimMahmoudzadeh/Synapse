package ir.rahim.synapse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import ir.rahim.library.navigation.screens.Screens

@Composable
fun NavDisplay(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Screens>(Screens.Login) }

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screens.Login> {

            }
        }
    )
}