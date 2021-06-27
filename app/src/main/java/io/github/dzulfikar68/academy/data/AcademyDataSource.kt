package io.github.dzulfikar68.academy.data

import androidx.lifecycle.LiveData
import io.github.dzulfikar68.academy.data.source.local.entity.CourseEntity
import io.github.dzulfikar68.academy.data.source.local.entity.ModuleEntity

interface AcademyDataSource {

    fun getAllCourses(): LiveData<List<CourseEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    fun getCourseWithModules(courseId: String): LiveData<CourseEntity>

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>

    fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>
}