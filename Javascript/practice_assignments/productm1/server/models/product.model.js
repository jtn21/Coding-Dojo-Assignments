const mongoose = require('mongoose')

const ProductSchema = new mongoose.Schema({
    title : {type: String},
    price: {type: Number},
    description: {type: String}

})

// will force use of curly braces if module.exports.product {}
module.exports = mongoose.model('Product', ProductSchema)