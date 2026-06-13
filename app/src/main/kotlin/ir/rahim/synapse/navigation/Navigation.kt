package ir.rahim.synapse.navigation


//@Composable
//fun NavDisplay(modifier: Modifier = Modifier) {
//    val backStack = rememberSynapseNavBackStack(Screens.Login)
//
//    NavDisplay(
//        modifier = modifier,
//        backStack = backStack,
//        onBack = { backStack.removeLastOrNull() },
//        entryProvider = entryProvider {
//            entry<Screens.Login> {
//            }
//        }
//    )
//}

//@Composable
//fun rememberSynapseNavBackStack(vararg elements: Screens): NavBackStack<Screens> {
//    return rememberSerializable(serializer = serializer()) {
//        NavBackStack(*elements)
//    }
//}