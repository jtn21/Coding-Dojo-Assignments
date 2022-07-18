// import dependencies

const express = require("express")
const app = express()
const {faker} = require('@faker-js/faker')


// express config
app.use(express.json())
app.use(express.urlencoded({extended: true}))


class User{
    constructor(){
        this.firstName = faker.name.firstName()
        this.lastName = faker.name.lastName()
        this.phoneNumber = faker.phone.number()
        this.password = faker.internet.password()
        this.email = faker.internet.email()
        this._id = faker.database.mongodbObjectId()
    }
}

class Company{
    constructor(){
        this._id = faker.database.mongodbObjectId()
        this.companyName = faker.company.companyName()
        this.addressStreet = faker.address.street()
        this.city = faker.address.city()
        this.state = faker.address.state()
        this.zipCode = faker.address.zipCode()
        this.country = faker.address.country()
    }
}


// routes
app.get("/api/randomName", (req,res)=>{
    const randomName = faker.name.findName()
    res.json(randomName)
})

app.get("/api/users/new", (req,res)=>{
    const newUser = new User()
    res.json(newUser)
})

app.get("/api/companies/new", (req,res)=>{
    const newCompany = new Company()
    res.json(newCompany)
})

app.get("/api/user/company", (req,res)=>{
    let userCompany = {
        User: new User(),
        Company : new Company ()
    }
    res.json(userCompany)
})

// listen to port
app.listen(8000, ()=>console.log(`Listening to port:8000`))