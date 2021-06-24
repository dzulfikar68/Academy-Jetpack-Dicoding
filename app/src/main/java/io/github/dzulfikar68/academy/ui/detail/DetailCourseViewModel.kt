package io.github.dzulfikar68.academy.ui.detail

import androidx.lifecycle.ViewModel
import io.github.dzulfikar68.academy.data.CourseEntity
import io.github.dzulfikar68.academy.data.ModuleEntity
import io.github.dzulfikar68.academy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourses()
        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}