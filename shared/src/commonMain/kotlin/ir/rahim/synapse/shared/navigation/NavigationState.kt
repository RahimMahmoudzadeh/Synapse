package ir.rahim.synapse.shared.navigation


//private val synapseSerializersModule = SerializersModule {
//    polymorphic(SynapseRoute::class) {
//        subclassesOfSealed<LoginRoute>()
//        subclassesOfSealed<ChatRoute>()
//    }
//}
//
//@Composable
//fun rememberNavigationState(
//    startRoute: NavKey, topLevelRoutes: Set<NavKey>
//): NavigationState {
//
//    val topLevelRoute = rememberSerializable(
//        startRoute, topLevelRoutes,
//        configuration = config,
//        serializer = MutableStateSerializer(PolymorphicSerializer(NavKey::class))
//    ) {
//        mutableStateOf(startRoute)
//    }
//
//    val backStacks = topLevelRoutes.associateWith { key ->
//        rememberNavBackStack(config, key)
//    }
//
//    return remember(startRoute, topLevelRoutes) {
//        NavigationState(
//            startRoute = startRoute, topLevelRoute = topLevelRoute, backStacks = backStacks
//        )
//    }
//}
//
///**
// * State holder for navigation state.
// *
// * @param startRoute - the start route. The user will exit the app through this route.
// * @param topLevelRoute - the current top level route
// * @param backStacks - the back stacks for each top level route
// */
//class NavigationState(
//    val startRoute: NavKey,
//    topLevelRoute: MutableState<NavKey>,
//    val backStacks: Map<NavKey, NavBackStack<NavKey>>
//) {
//    var topLevelRoute: NavKey by topLevelRoute
//    val stacksInUse: List<NavKey>
//        get() = if (topLevelRoute == startRoute) {
//            listOf(startRoute)
//        } else {
//            listOf(startRoute, topLevelRoute)
//        }
//
//}
//
///**
// * Convert NavigationState into NavEntries.
// */
//@Composable
//fun NavigationState.toEntries(
//    entryProvider: (NavKey) -> NavEntry<NavKey>
//): SnapshotStateList<NavEntry<NavKey>> {
//
//    val decoratedEntries = backStacks.mapValues { (_, stack) ->
//        val decorators = listOf(
//            rememberSaveableStateHolderNavEntryDecorator<NavKey>(),
//        )
//        rememberDecoratedNavEntries(
//            backStack = stack, entryDecorators = decorators, entryProvider = entryProvider
//        )
//    }
//
//    return stacksInUse.flatMap { decoratedEntries[it] ?: emptyList() }.toMutableStateList()
//}