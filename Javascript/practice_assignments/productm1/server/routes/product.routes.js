const ProductController = require('../controllers/product.controller')


module.exports = (app) =>{
    app.get("/api/test", ProductController.testApi)
    app.post("/api/product", ProductController.addProduct)
    app.get("/api/product", ProductController.allProducts)
    app.get("/api/product/:id", ProductController.oneProduct)
    app.put("/api/product/:id", ProductController.updateProduct)
    app.delete("/api/product/:id", ProductController.deleteProduct)
}