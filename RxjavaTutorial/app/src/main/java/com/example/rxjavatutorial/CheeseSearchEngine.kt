

package com.example.rxjavatutorial

import android.content.Context
import android.util.Log
import com.example.rxjavatutorial.database.Cheese
import com.example.rxjavatutorial.database.CheeseDatabase

class CheeseSearchEngine(private val context: Context) {

  fun search(query: String): List<Cheese>? {
    Thread.sleep(2000)
    Log.d("Searching", "Searching for $query")
    return CheeseDatabase.getInstance(context).cheeseDao().findCheese("%$query%")
  }

}