const {response} = require('express')
const jokeRoutes = require('../routes/jokes.routes')
const jokesModels = require('./../models/jokes.models')
const joke = require('./../models/jokes.models')

//get all
module.exports.allJokes = (req,res) => {
    joke.find()
    .then(jokes => res.json(jokes))
    .catch(err => res.json(err))
}


//create

module.exports.addJoke = (req, res) => {
    const newJoke = req.body;
    joke.create(newJoke)
        .then(joke => res.json(joke))
        .catch(err => res.json(err));
}

//get one
module.exports.oneJoke = (req, res) => {
    const idFromParams = req.params.id;
    joke.findOne({_id: idFromParams})
        .then(oneJoke => res.json(oneJoke))
        .catch(err=> res.json(err))
}


//update
module.exports.updateJoke = (req, res) => {
    const idFromParams = req.params.id;
    const updateValue = req.body
    joke.findOneAndUpdate(
        {_id: idFromParams},
        updateValue,
        {new: true, runValidators: true}
    )
        .then(updateJoke => res.json(updateJoke))
        .catch(err=> res.json(err))
}


//delete

module.exports.deleteJoke = (req,res) => {
    joke.deleteOne({_id: req.params.id})
        .then(message => res.json(message))
        .catch(err=> res.son(err))
    
}