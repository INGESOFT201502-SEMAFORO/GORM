package gorm

class Admin extends User{
    int level
    double rating

    static constraints = {
        level(nullable: false, range: 1..5)
        rating(nullable: false, range: 1.0..100.0)
    }
}
