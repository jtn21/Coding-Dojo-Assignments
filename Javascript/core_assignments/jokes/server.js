
//import dependencies
const express = require("express")
const app = express()
//mongoose config
require(`./server/config/mongoose.config`)

// express config
app.use(express.json())
app.use(express.urlencoded({extended: true}))

// get the routes

require('./server/routes/jokes.routes')(app);


// listen to port
app.listen(8000, ()=> console.log("Listening to the port 8000"))