package com.lffq.trackerapp.network

object RepositoryProvider {
        fun provideSearchRepository(): Repository {
            return Repository(CovidApi.create())
    }
}