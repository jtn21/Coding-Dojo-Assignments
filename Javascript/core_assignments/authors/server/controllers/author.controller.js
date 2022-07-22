const {response} = require('express');
const authorRoutes = require('../routes/author.routes');
const Author = require('../models/author.model');


module.exports.testApi = (req,res)=>{
    res.json({status:'ok'})
}

//get all
module.exports.allAuthors = (req,res) => {
    Author.find()
    .then(authors => res.json(authors))
    .catch(err => res.json(err))
}


//create

module.exports.addAuthor = (req, res) => {
    const newAuthor = req.body;
    Author.create(newAuthor)
        .then(author => res.json(author))
        .catch(err => res.status(400).json(err));
}

//get one
module.exports.oneAuthor = (req, res) => {
    const idFromParams = req.params.id;
    Author.findOne({_id: idFromParams})
        .then(oneAuthor => res.json(oneAuthor))
        .catch(err=> res.json(err))
}


//update
module.exports.updateAuthor = (req, res) => {
    const idFromParams = req.params.id;
    const updateValue = req.body
    Author.findOneAndUpdate(
        {_id: idFromParams},
        updateValue,
        {new: true, runValidators: true}
    )
        .then(updateAuthor => res.json(updateAuthor))
        .catch(err=> res.status(400).json(err))
}


//delete

module.exports.deleteAuthor = (req,res) => {
    Author.deleteOne({_id: req.params.id})
        .then(message => res.json(message))
        .catch(err=> res.son(err))
    
}