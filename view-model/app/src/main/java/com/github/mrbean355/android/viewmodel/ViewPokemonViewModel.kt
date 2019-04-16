package com.github.mrbean355.android.viewmodel

class ViewPokemonViewModel {
    private val repository = PokemonRepository()
    private var items: List<Pokemon>? = null

    fun initialise(callback: (items: List<Pokemon>) -> Unit) {
        val items = this.items
        if (items != null) {
            callback(items)
        } else {
            Thread {
                this.items = repository.getAll()
                callback(this.items.orEmpty())
            }.start()
        }
    }
}