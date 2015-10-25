package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostSpec extends Specification {




    void "error number 1"(){
        when:

        def postBueno = new Post(
                topic:"pt"

                //dateCreated: new Date(2016,11,19)
        )

        then:
        !postBueno.validate()
    }

    void "exito numero 1"(){
        when:

        def postBueno = new Post(
                topic:"soy prueba aprobada"

                //dateCreated: new Date(2016,11,19)
        )

        then:
        postBueno.validate()
    }



}