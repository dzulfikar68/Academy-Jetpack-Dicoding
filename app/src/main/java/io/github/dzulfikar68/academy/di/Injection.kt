package io.github.dzulfikar68.academy.di

import android.content.Context
import io.github.dzulfikar68.academy.data.AcademyRepository
import io.github.dzulfikar68.academy.data.source.remote.RemoteDataSource
import io.github.dzulfikar68.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}