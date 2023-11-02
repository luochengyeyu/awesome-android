package com.lycc.arch.room.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.lycc.arch.R
import com.lycc.arch.databinding.ActivityNewWordBinding
import com.dylanc.viewbinding.binding
import com.orhanobut.logger.Logger

class NewWordActivity : AppCompatActivity(R.layout.activity_new_word) {

    private val binding: ActivityNewWordBinding by binding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding.editWord.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = binding.editWord.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.lycc.arch.room.wordlistsql.REPLY"
    }
}