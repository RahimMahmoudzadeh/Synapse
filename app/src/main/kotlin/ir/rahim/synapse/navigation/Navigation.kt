package ir.rahim.synapse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import ir.rahim.library.navigation.screens.Screens
import kotlinx.serialization.serializer

@Composable
fun NavDisplay(modifier: Modifier = Modifier) {
    val backStack = rememberSynapseNavBackStack(Screens.Login)

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

@Composable
fun rememberSynapseNavBackStack(vararg elements: Screens): NavBackStack<Screens> {
    return rememberSerializable(serializer = serializer()) {
        NavBackStack(*elements)
    }
}