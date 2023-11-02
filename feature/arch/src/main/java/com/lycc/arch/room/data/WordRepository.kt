package com.lycc.arch.room.data

import androidx.annotation.WorkerThread
import com.lycc.arch.room.data.local.dao.WordDao
import com.lycc.arch.room.data.local.entity.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}