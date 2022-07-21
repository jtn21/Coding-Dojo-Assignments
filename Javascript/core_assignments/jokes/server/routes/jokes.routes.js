const JokeController = require('../controllers/joke.controllers')


module.exports = (app) =>{
    app.post("/api/joke", JokeController.addJoke)
    app.get("/api/joke", JokeController.allJokes)
    app.get("/api/joke/:id", JokeController.oneJoke)
    app.put("/api/joke/:id", JokeController.updateJoke)
    app.delete("/api/joke/:id", JokeController.deleteJoke)
}