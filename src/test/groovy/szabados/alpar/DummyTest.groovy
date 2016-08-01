package szabados.alpar

import spock.lang.Specification

/*
 * This is the `test` code, i.e. the specification for what we guarantee about our application.
 */

class DummyTest extends Specification { // TODO change to your own
    /*@formatter:off*/
    def 'simple assertion'() {
        when:   def value = DummyClass.dummyMethod()
        then:   !value.empty
    }

    def 'data driven test'() {
        when:   def value = DummyClass.dummyMethod2(a, b)
        then:   value == c

        where:  a  | b || c
                7  | 4 || 11
                0  | 0 || 0
                -1 | 3 || 2
    }
    /*@formatter:on*/
}