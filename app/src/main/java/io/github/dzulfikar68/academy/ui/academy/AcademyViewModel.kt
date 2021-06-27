package io.github.dzulfikar68.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.dzulfikar68.academy.data.source.local.entity.CourseEntity
import io.github.dzulfikar68.academy.data.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}