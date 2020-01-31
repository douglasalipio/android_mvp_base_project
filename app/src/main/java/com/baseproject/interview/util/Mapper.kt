package com.baseproject.interview.util

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}
