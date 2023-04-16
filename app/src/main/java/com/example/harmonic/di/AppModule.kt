package com.example.harmonic.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.harmonic.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGlideInstance(@ApplicationContext context: Context) =
        Glide.with(context) //@ApplicationContext, which is a Dagger Hilt-provided annotation that indicates that the Context object should be provided by the application context rather than the activity context.
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.ic_iamge)
                    .error(R.drawable.ic_iamge)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)//This means that Glide will only cache the raw bytes of the image, rather than any transformed versions of the image
            )
}