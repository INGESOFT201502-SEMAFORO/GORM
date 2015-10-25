package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Forum)
class ForumSpec extends Specification {

    void "El nombre no puede ser null"() {
        when :
        def user = new Forum(

                name: null,
                dateCreated: new Date(),
                category: "hola"
        )
        then :
        !user.validate()
    }
    void "La fecha no puede ser null"() {
        when :
        def user = new Forum(

                name: "Cesar",
                dateCreated: null,
                category: "hola"
        )
        then :
        !user.validate()
    }
    void "La categoria no puede ser null"() {
        when :
        def user = new Forum(

                name: "cesar",
                dateCreated: new Date(),
                category: null
        )
        then :
        !user.validate()
    }
    void "El nombre no puede estar vacío"() {
        when :
        def user = new Forum(

                name: "",
                dateCreated: new Date(),
                category: "hola"
        )
        then :
        !user.validate()
    }

    void "La categoria no puede estar vacío"() {
        when :
        def user = new Forum(

                name: "cesar",
                dateCreated: new Date(),
                category: ""
        )
        then :
        !user.validate()
    }
}
