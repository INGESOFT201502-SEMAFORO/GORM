package gorm

class ControllerFilters {

    def filters = {
        adminControllerFilter(controller: 'admin', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.AdminController").create()
                    applicationContext.getBean("gorm.AdminController").show()
                    applicationContext.getBean("gorm.AdminController").update()
                    applicationContext.getBean("gorm.AdminController").delete()
                } else {
                    redirect(controller: 'admin', action: 'index')
                    return false
                }
            }
        }
        fileControllerFilter(controller: 'file', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.FileController").create()
                    applicationContext.getBean("gorm.FileController").show()
                    applicationContext.getBean("gorm.FileController").update()
                    applicationContext.getBean("gorm.FileController").delete()
                } else {
                    redirect(controller: 'file', action: 'index')
                    return false
                }
            }
        }
        forumControllerFilter(controller: 'forum', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.ForumController").create()
                    applicationContext.getBean("gorm.ForumController").show()
                    applicationContext.getBean("gorm.ForumController").update()
                    applicationContext.getBean("gorm.ForumController").delete()
                } else {
                    redirect(controller: 'forum', action: 'index')
                    return false
                }
            }
        }
        postControllerFilter(controller: 'post', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.PostController").create()
                    applicationContext.getBean("gorm.PostController").show()
                    applicationContext.getBean("gorm.PostController").update()
                    applicationContext.getBean("gorm.PostController").delete()
                } else {
                    redirect(controller: 'post', action: 'index')
                    return false
                }
            }
        }
        regularControllerFilter(controller: 'regular', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.RegularController").create()
                    applicationContext.getBean("gorm.RegularController").show()
                    applicationContext.getBean("gorm.RegularController").update()
                    applicationContext.getBean("gorm.RegularController").delete()
                } else {
                    redirect(controller: 'regular', action: 'index')
                    return false
                }
            }
        }
        userControllerFilter(controller: 'user', action: '*', actionExclude: 'index') {
            before = {
                if(session.authStatus.equals('logged')) {
                    applicationContext.getBean("gorm.UserController").create()
                    applicationContext.getBean("gorm.UserController").show()
                    applicationContext.getBean("gorm.UserController").update()
                    applicationContext.getBean("gorm.UserController").delete()
                } else {
                    redirect(controller: 'user', action: 'index')
                    return false
                }
            }
        }
    }
}