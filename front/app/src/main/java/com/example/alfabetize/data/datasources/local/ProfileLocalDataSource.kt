package com.example.alfabetize.data.datasources.local

import com.example.alfabetize.data.datasources.local.daos.ProfileDao
import com.example.alfabetize.data.datasources.local.entities.Profile

class ProfileLocalDataSource(
    private val profileDao: ProfileDao
) : IProfileLocalDataSource {
    override suspend fun getAllProfiles(): List<Profile> = profileDao.index()

    override suspend fun getProfile(id: Int): Profile? = profileDao.show(id)

    override suspend fun insertProfile(profile: Profile) = profileDao.store(profile)

    override suspend fun updateProfile(profile: Profile) = profileDao.update(profile)

    override suspend fun deleteProfile(profile: Profile) = profileDao.destroy(profile)

    override suspend fun getProfileByUserId(userId: Int): Profile? = profileDao.findByUserId(userId)
}