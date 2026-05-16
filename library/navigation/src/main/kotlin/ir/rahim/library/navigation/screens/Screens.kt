package ir.rahim.library.navigation.screens

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface Screens: NavKey {
    data object Login: Screens
    data object Home: Screens
}