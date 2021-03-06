package br.org.cesar.discordtime.stickysessions.data.repository.mapper

import br.org.cesar.discordtime.stickysessions.data.remote.model.SessionRemote
import br.org.cesar.discordtime.stickysessions.domain.model.Session
import br.org.cesar.discordtime.stickysessions.factory.SessionFactory
import br.org.cesar.discordtime.stickysessions.factory.SessionRemoteFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.Year
import java.util.*

class SessionMapperTest {

    private lateinit var sessionMapper: SessionMapper

    @Before
    fun setUp() {
        sessionMapper = SessionMapper()
    }

    @Test
    fun mapFromDomain() {
        val session = SessionFactory.makeSession(5)
        val sessionRemote = sessionMapper.mapFromDomain(session)

        assertSessionEquality(session, sessionRemote)
    }

    @Test
    fun mapToDomain() {
        val sessionRemote = SessionRemoteFactory.makeSessionRemote(5)
        val session = sessionMapper.mapToDomain(sessionRemote)

        assertSessionEquality(session, sessionRemote)
    }

    private fun assertSessionEquality(session: Session, sessionRemote: SessionRemote) {
        assertEquals(session.id, sessionRemote.id)
        assertTrue(session.topics.toTypedArray() contentEquals sessionRemote.topics.toTypedArray())

        var calendar = Calendar.getInstance()
        calendar.timeInMillis = sessionRemote.timestamp

        assertEquals(session.year, calendar.get(Calendar.YEAR))
        assertEquals(session.month, calendar.get(Calendar.MONTH))
        assertEquals(session.day, calendar.get(Calendar.DAY_OF_MONTH))
    }
}