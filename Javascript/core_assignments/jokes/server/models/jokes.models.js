const mongoose = require('mongoose')

const JokeSchema = new mongoose.Schema({
    question: {type: String},
    answer: {type: String}

})


module.exports = mongoose.model('joke', JokeSchema)