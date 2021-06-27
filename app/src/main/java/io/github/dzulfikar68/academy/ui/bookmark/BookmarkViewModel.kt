package io.github.dzulfikar68.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.dzulfikar68.academy.data.source.local.entity.CourseEntity
import io.github.dzulfikar68.academy.data.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getBookmarks(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}