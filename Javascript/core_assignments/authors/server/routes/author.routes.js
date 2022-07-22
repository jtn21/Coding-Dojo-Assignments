const AuthorController = require('../controllers/author.controller')

module.exports = (app) =>{
    app.get("/api/test", AuthorController.testApi)
    app.post("/api/author", AuthorController.addAuthor)
    app.get("/api/author", AuthorController.allAuthors)
    app.get("/api/author/:id", AuthorController.oneAuthor)
    app.put("/api/author/:id", AuthorController.updateAuthor)
    app.delete("/api/author/:id", AuthorController.deleteAuthor)
}