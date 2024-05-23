package com.example.alfabetize.data.datasources.local

import com.example.alfabetize.data.datasources.local.daos.UserDao
import com.example.alfabetize.data.datasources.local.entities.User

class UserLocalDataSource(
    private val userDao: UserDao
) : IUserLocalDataSource {
    override suspend fun getAllUsers(): List<User> = userDao.index()

    override suspend fun insertUser(user: User) = userDao.store(user)

    override suspend fun deleteUser(user: User) = userDao.destroy(user)

    override suspend fun updateUser(user: User) = userDao.update(user)

    override suspend fun getUser(id: Int): User = userDao.show(id)
}