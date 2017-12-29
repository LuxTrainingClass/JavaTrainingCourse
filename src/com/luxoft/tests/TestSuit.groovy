package com.luxoft.tests

import junit.framework.Test
import junit.textui.TestRunner

class Tests {
    static Test suite() {
        def allTests = new GroovyTestSuite()
        allTests.addTestSuite(Task01Test.class)
        allTests.addTestSuite(Task03Test.class)
        allTests.addTestSuite(Task04Test.class)
        allTests.addTestSuite(Task05Test.class)
        allTests.addTestSuite(Task06Test.class)
        return allTests
    }
}

TestRunner.run(Tests.suite())
