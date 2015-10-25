package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Regular)
class RegularSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test de restricciones no nulas"(){
        when: 'se crea un usuario con todas las restricciones, y limites inferiores'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: 0, starsNumber: 0)
        then: 'la validacion debe pasar'
        regular.validate()
        !regular.hasErrors()
        regular.errors.errorCount == 0

        when: 'se crea un usuario con todas las restricciones, y limites superiores'
        regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 1, strikesNumber: 3, starsNumber: 5)
        then: 'la validacion debe pasar'
        regular.validate()
        !regular.hasErrors()
        regular.errors.errorCount == 0
    }

    void "test postViews nulo"(){
        when: 'el atributo postViews es null'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: null, strikesNumber: 0, starsNumber: 0)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.errorCount == 1
    }

    void "test strikesNumber nulo"(){
        when: 'el atributo strikesNumber es null'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: null, starsNumber: 0)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.errorCount == 1
    }

    void "test starsNumber nulo"(){
        when: 'el atributo starsNumber es null'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: 0, starsNumber: null)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.errorCount == 1
    }

    void "test postViews range"() {
        when: 'el atributo postViews es menor a 0'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: -1, strikesNumber: 0, starsNumber: 0)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.errorCount == 1
    }

    void "test strikeNumber range"() {
        when: 'el atributo StrikeNumber es menor a 0'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: -1, starsNumber: 0)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.fieldError.code == 'range.toosmall'

        when: 'el atributo StrikeNumber es mayor a 3'
        regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: 4, starsNumber: 0)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.fieldError.code == 'range.toobig'
    }

    void "test starsNumber range"() {
        when: 'el atributo starsNumber es menor a 0'
        def regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: 0, starsNumber: -1)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.fieldError.code == 'range.toosmall'

        when: 'el atributo StrikeNumber es mayor a 5'
        regular = new Regular(name: 'juan', lastname: 'arias', age: 22, username: 'jpariasc',
                password: 'aA1aaA1a', postViews: 0, strikesNumber: 0, starsNumber: 6)
        then: 'la validacion debe fallar'
        !regular.validate()
        regular.hasErrors()
        regular.errors.fieldError.code == 'range.toobig'
    }
}
