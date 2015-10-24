package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    void "usuariovalido"() {
        when:
        def Sergio = new User(
                name: 'Esteban',
                lastname: 'Gabalan',
                age: 44,
                username: 'sumadresama',
                password: 'Qwerty12345'
        )
        then:
        Sergio.validate()
    }
    void "usuarioinvalido"() {
        when:
        def David = new User(
                name: null,
                lastname: 'ui',
                age: 9,
                username: 'sumadresama',
                password: 'hola'
        )
        then:
        !David.validate()

    }


}