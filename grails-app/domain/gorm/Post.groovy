package gorm

class Post {

    String topic
    //Date dateCreated
    //Date lastUpdate



    static constraints = {

        topic (blank: false, size: 3..50)
        //dateCreated (min:new Date())
        //lastUpdate (min:new Date())
        //ArrayList<String> comments
    }

    static hasMany = [ files: File ]

    static belongsTo = [ forum: Forum, regular: Regular ]

    static mapping = {

        regular column: 'owner_id'
        forum column: 'fatherForum_id'

    }

    //def antesInsertar() {

    //dateCreated = new Date()

    //}

    //def antesActualizar() {

    //lastUpdate = new Date()

    //}



}