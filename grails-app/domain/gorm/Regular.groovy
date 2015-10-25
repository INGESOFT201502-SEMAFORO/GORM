package gorm

class Regular extends User{
    int postViews
    int strikesNumber
    int starsNumber

    static hasMany = [posts : Post]

    static constraints = {
        postViews(nullable: false, min: 0)
        strikesNumber(nullable: false, range: 0..3)
        starsNumber(nullable: false, range: 0..5)
    }
}