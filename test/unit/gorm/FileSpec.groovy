package gorm

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(File)
class FileSpec extends Specification {

    void "MIME type correcto, content correcto, size correcto"() {
        when: "El MIME type que se pasa corresponde a una notacion estandar"
        def file = new File(fileType: "text/html", content: [60, 33, 68, 79, 67, 84, 89, 80], size: 8)
        then: "El archivo puede guardarse"
        file.validate()
    }
    void "MIME type incorrecto"() {
        when: "El MIME type que se pasa no corresponde a una notacion estandar"
        def file = new File(fileType: ".html", content: [60, 33, 68, 79, 67, 84, 89, 80], size: 8)
        then: "No es posbile guardar el archivo"
        !file.validate()  // must fail!
    }

    void "content vacio (sin bytes)"() {
        when: "El archivo no contiene bytes"
        def file = new File(fileType: "text/html", content: [], size: 0)
        then: "No es posible guardar el archivo"
        !file.validate()
    }

    void "content muy grande - mas de 10 MB"() {
        setup: "Generar un arreglo aleatorio de 10000001 Bytes"
        def contents = new byte [10000001]
        Random random = new Random()
        random.nextBytes(contents)
        when: "El archivo contiene mas bytes de los permitidos"
        def file = new File(fileType: "text/html", content: contents, size: contents.size())
        then: "No es posible guardar el archivo"
        !file.validate()
    }

}
