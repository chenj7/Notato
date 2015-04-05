package com.chenj7.notato

import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Note)
class NoteSpec extends Specification {

    def setup() {
        mockDomain(Note)
    }

    def cleanup() {
    }

    void "should accept notes with message and timestamp"() {
        when:
            Note note = new Note(contents: "This is a note", timestamp: new Date())

        then: "validation should pass"
            note.validate()
    }

    void "should reject notes with no content"() {
        when: "note with no contents is passed"
            Note note = new Note(timestamp: new Date())

        then: "validation should not pass"
            !note.validate()
    }

    void "should reject notes with empty content"() {
        when: "note with empty contents is passed"
            Note note = new Note(contents: "", timestamp: new Date())

        then: "validation should not pass"
            !note.validate()
    }

    void "should reject notes with just whitespace content"() {
        when: "note with just blank spaces is passed"
            Note note = new Note(contents: "   ", timestamp: new Date())

        then: "validation should not pass"
            !note.validate()
    }

    void "shoudl reject notes without timestamp"() {
        when: "note with no timestamp is passed"
            Note note = new Note(contents: "This is a note")

        then: "validation should not pass"
            !note.validate()
    }
}
