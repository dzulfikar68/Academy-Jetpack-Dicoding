package io.github.dzulfikar68.academy.ui.bookmark

import io.github.dzulfikar68.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
