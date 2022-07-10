import React, {useState} from 'react';
import Display from './Display';



const Userform = () => {
    const[firstname, setFirstname] = useState("");
    const[lastname, setLastname] = useState("");
    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[confirmpw, setConfirmpw] = useState("");

    return (
        <div>
            <h1>Form</h1>
            <p>
                <label>First Name:</label>
                <input type="text" name="firstname" onChange={(e)=>setFirstname(e.target.value)} value={firstname}/> 
                {
                    firstname.length < 2? 
                    <span style={{color: "red"}}> First Name should be at least 2 characters</span> :""
                }
            </p>
            <p>
                <label>Last Name:</label>
                <input type="text" name="lastname" onChange={(e)=>setLastname(e.target.value)} value={lastname}/> 
                {
                    lastname.length < 2?
                    <span style={{color: "red"}}> Last Name should be at least 2 characters</span> :""
                }
            </p>
            <p>
                <label>Email:</label>
                <input type="text" name="email" onChange={(e)=>setEmail(e.target.value)} value={email}/> 
                {
                    email.length < 5?
                    <span style={{color: "red"}}> Email should be at least 5 characters</span> :""
                }
            </p>
            <p>
                <label>Password:</label>
                <input type="password" name="password" onChange={(e)=>setPassword(e.target.value)} value={password}/> 
                {
                    password.length < 8?
                    <span style={{color: "red"}}> Password should be at least 8 characters.</span> :""
                }
                {
                    password != confirmpw?
                    <span style={{color: "red"}}> Passwords must match.</span> :""
                }
            </p>
            <p>
                <label>Confirm Password:</label>
                <input type="password" name="confirmpw" onChange={(e)=>setConfirmpw(e.target.value)} value={confirmpw}/> 
                {
                    confirmpw.length < 8?
                    <span style={{color: "red"}}> Password should be at least 8 characters.</span> :""
                }
                {
                    password != confirmpw?
                    <span style={{color: "red"}}> Passwords must match.</span> :""
                }
            </p>

            <Display firstname = {firstname} lastname = {lastname} email ={email} password = {password} confirmpw = {confirmpw} />
        </div>

        

    )
}

export default Userform