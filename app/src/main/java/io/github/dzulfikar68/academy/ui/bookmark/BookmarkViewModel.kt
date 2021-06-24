package io.github.dzulfikar68.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import io.github.dzulfikar68.academy.data.CourseEntity
import io.github.dzulfikar68.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}