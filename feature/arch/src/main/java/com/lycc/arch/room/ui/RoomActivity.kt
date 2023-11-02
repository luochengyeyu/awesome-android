package com.lycc.arch.room.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dylanc.viewbinding.binding
import com.lycc.arch.App
import com.lycc.arch.R
import com.lycc.arch.databinding.ActivityRoomBinding
import com.lycc.arch.room.data.local.entity.Word
import com.lycc.arch.room.vm.WordViewModel
import com.lycc.arch.room.vm.WordViewModelFactory
import com.lycc.core.ext.toast

class RoomActivity : AppCompatActivity(R.layout.activity_room) {

    private val binding: ActivityRoomBinding by binding()
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as App).repository)
    }
    private lateinit var mAdapter: WordListAdapter

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        val requestCode = result.resultCode
        val resultCode = result.resultCode
        if (resultCode == Activity.RESULT_OK) {
            result.data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                wordViewModel.insert(Word(it))
            }
        } else {
            toast(R.string.empty_not_saved)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Room"
        binding.run {
            recyclerview.run {
                mAdapter = WordListAdapter()
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@RoomActivity)
            }
            fab.setOnClickListener {
                startForResult.launch(Intent(this@RoomActivity,NewWordActivity::class.java))
            }
        }
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { mAdapter.submitList(it) }
        })
    }

}