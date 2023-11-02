package com.lycc.arch

import android.app.Application
import com.lycc.arch.room.data.WordRepository
import com.lycc.arch.room.data.local.WordRoomDatabase
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class App : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
    override fun onCreate() {
        super.onCreate()
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .tag("LCYY") // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}