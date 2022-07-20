const { response } = require('express');
const productRoutes = require('../routes/product.routes');
const Product = require('./../models/product.model')


module.exports.testApi = (req,res)=>{
    res.json({status:'ok'})
}

//get all
module.exports.allProducts = (req,res) => {
    Product.find()
    .then(products => res.json(products))
    .catch(err => res.json(err))
}


//create

module.exports.addProduct = (req, res) => {
    const newProduct = req.body;
    Product.create(newProduct)
        .then(product => res.json(product))
        .catch(err => res.json(err));
}

//get one
module.exports.oneProduct = (req, res) => {
    const idFromParams = req.params.id;
    Product.findOne({_id: idFromParams})
        .then(oneProduct => res.json(oneProduct))
        .catch(err=> res.json(err))
}


//update
module.exports.updateProduct = (req, res) => {
    const idFromParams = req.params.id;
    const updateValue = req.body
    Product.findOneAndUpdate(
        {_id: idFromParams},
        updateValue,
        {new: true, runValidators: true}
    )
        .then(updateProduct => res.json(updateProduct))
        .catch(err=> res.json(err))
}


//delete

module.exports.deleteProduct = (req,res) => {
    Product.deleteOne({_id: req.params.id})
        .then(message => res.json(message))
        .catch(err=> res.son(err))
    
}