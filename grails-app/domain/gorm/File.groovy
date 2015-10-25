package gorm

class File {

    String fileType
    Byte [] content
    Double size

    static constraints = {
        fileType(blank: false, nullable: false, matches: /.+\/.+/)
        // el archivo no deberia contener mas de 10 MB, y al menos un byte (no vacío)
        content(nullable: false, maxSize: 10*1000*1000, minSize: 1)
        size(max: 10*1000*1000 as Double, min: 1 as Double) // asumiendo que 1MB = 1000KB and 1KB = 1000 bytes
    }
}
