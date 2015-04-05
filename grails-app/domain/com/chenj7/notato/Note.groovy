package com.chenj7.notato

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
@EqualsAndHashCode
class Note {

    Date timestamp
    String contents

    static constraints = {
    }
}
