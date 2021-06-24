package io.github.dzulfikar68.academy.ui.academy

import androidx.lifecycle.ViewModel
import io.github.dzulfikar68.academy.data.CourseEntity
import io.github.dzulfikar68.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()

}