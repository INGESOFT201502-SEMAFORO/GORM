package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Admin)
class AdminSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Admin)
    }

    def cleanup() {
    }

    void "Test de restricciones no nulas"(){
        when: 'se crea un admin con todas las restricciones, y limites inferiores'
        def admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 1, rating: 1.0)
        then: 'la validacion debe pasar'
        admin.validate()
        !admin.hasErrors()
        admin.errors.errorCount == 0

        when: 'se crea un Admin con todas las restricciones, y limites superiores'
        admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 5, rating: 100.0)
        then: 'la validacion debe pasar'
        admin.validate()
        !admin.hasErrors()
        admin.errors.errorCount == 0
    }

    void "test level nulo"(){
        when: 'el atributo level es null'
        def admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: null, rating: 50.0)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.hasErrors()
        admin.errors.errorCount == 1
    }

    void "test rating nulo"(){
        when: 'el atributo rating es null'
        def admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 3, rating: null)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.hasErrors()
        admin.errors.errorCount == 1
    }

    void "test level range"() {
        when: 'el atributo level es menor a 1'
        def admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 0, rating: 50.0)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.hasErrors()
        admin.errors.fieldError.code == 'range.toosmall'

        when: 'el atributo level es mayor a 5'
        admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 6, rating: 30.0)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.hasErrors()
        admin.errors.fieldError.code == 'range.toobig'
    }

    void "test rating range"() {
        when: 'el atributo rating es menor a 1.0'
        def admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', level: 1, rating: 0.0)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.hasErrors()
        admin.errors.fieldError.code == 'range.toosmall'

        when: 'el atributo rating es mayor a 101.0'
        //admin = new Admin(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
        //        password: 'aA1aaA1a', level: 1, rating: 101.0)
        admin.setRating(101.0)
        then: 'la validacion debe fallar'
        !admin.validate()
        admin.errors.hasFieldErrors ('rating')
        admin.errors.fieldError.code == 'range.toobig'
    }
}
