package com.niranjan.android.notekeeper

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.niranjan.android.notekeeper.databinding.ActivityNoteListBinding
import com.niranjan.android.notekeeper.databinding.ContentNoteListBinding

class NoteListAcitivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding
    private lateinit var noteListContent : ContentNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteListContent = ContentNoteListBinding.inflate(layoutInflater)
        setContentView(noteListContent.root)

        setSupportActionBar(binding.toolbar)

        //Minor changes to verify github

    }

}