package com.niranjan.android.notekeeper

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.niranjan.android.notekeeper.databinding.ActivityMainBinding
import com.niranjan.android.notekeeper.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var contentViewBinding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentViewBinding = ContentMainBinding.inflate(layoutInflater)
        setContentView(contentViewBinding.root)

        val adapterCourses =
            ArrayAdapter<CourseInfo>(
                this,
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList()
            )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        contentViewBinding.spinnerCourses.adapter = adapterCourses
    }
}