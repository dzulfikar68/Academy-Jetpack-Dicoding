package io.github.dzulfikar68.academy.ui.academy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.github.dzulfikar68.academy.data.AcademyRepository
import io.github.dzulfikar68.academy.data.source.local.entity.CourseEntity
import io.github.dzulfikar68.academy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<CourseEntity>>

    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }

    @Test
    fun getCourses() {
        val dummyCourses = DataDummy.generateDummyCourses()
        val courses = MutableLiveData<List<CourseEntity>>()
        courses.value = dummyCourses

        `when`(academyRepository.getAllCourses()).thenReturn(courses)
        val courseEntities = viewModel.getCourses().value
        verify(academyRepository).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getCourses().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}