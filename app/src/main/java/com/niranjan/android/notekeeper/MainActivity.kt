package com.niranjan.android.notekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.niranjan.android.notekeeper.databinding.ActivityMainBinding
import com.niranjan.android.notekeeper.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contentViewBinding: ContentMainBinding
    private var notePosition = Constants.POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentViewBinding = ContentMainBinding.inflate(layoutInflater)
        setContentView(contentViewBinding.root)
        setSupportActionBar(contentViewBinding.toolbar)


        val adapterCourses =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList()
            )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        contentViewBinding.spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(Constants.EXTRA_NOTE_POSITION, Constants.POSITION_NOT_SET)

        if (notePosition != Constants.POSITION_NOT_SET) {
            displayNote()
        }
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        binding.content.noteTitle.setText(note.title)
        binding.content.noteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        binding.content.spinnerCourses.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionSettings -> true
            R.id.actionNext -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
    }
}