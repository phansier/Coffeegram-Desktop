package ru.beryukhov.coffeegram.data

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.beryukhov.coffeegram.model.NavigationIntent
import ru.beryukhov.coffeegram.model.NavigationState
import ru.beryukhov.coffeegram.model.NavigationStore

class NavigationStoreAdapter(private val onViewState: ((NavigationState) -> Unit)? = null) {
    private val scope = MainScope()
    private val navStore = NavigationStore()

    fun newIntent(intent: NavigationIntent) = navStore.newIntent(intent)

    init {
        //ensureNeverFrozen()
        observe()
    }

    @OptIn(FlowPreview::class)
    fun observe() {
        if (onViewState != null) {
            scope.launch {
                //log.v { "Exposing flow through callbacks" }
                navStore.state.collect { viewState ->
                    onViewState.invoke(viewState)
                }
            }
        }
    }
}