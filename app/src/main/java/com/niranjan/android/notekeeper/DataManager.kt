package com.niranjan.android.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android programming with intents")
        courses[course.courseId] = course

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Fundamentals", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Core", courseId = "java_core")
        courses[course.courseId] = course
    }


    private fun initializeNotes() {
        var note = courses["android_intents"]?.let { NoteInfo(it, "test", "testDetail")}
        if (note != null) {
            notes.add(note)
        }
    }
}
