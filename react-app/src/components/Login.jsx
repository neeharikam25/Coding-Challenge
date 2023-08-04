import React, { useState } from "react";
import { Navigate,useNavigate } from 'react-router-dom';
import { ToastContainer,toast } from "react-toastify";
import { signInWithEmailAndPassword } from "firebase/auth";
import {auth} from '../config/firebase' 

const Login = () => {

  const [error, setError] = useState("");
  const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();


  const onLogin = (e) => {
    e.preventDefault();
    signInWithEmailAndPassword(auth, email, password)
    .then((userCredential) => {
        // Signed in
        const user = userCredential.user;
        navigate("/allBonds")
        console.log(user);
    })
    .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log(errorCode, errorMessage)
    });
   
}



  return (
      <div id="login">
        <h1>Log In</h1>
        <form id="form-container">
          <label htmlFor="username">Email</label>
          <input
        id="email-address"
        name="email"
        type="email"                                    
        required                                                                                
        placeholder="Email address"
        onChange={(e)=>setEmail(e.target.value)}
          />
          <label htmlFor="password">Password</label>
          <input
            id="password"
            name="password"
            type="password"                                    
            required                                                                                
            placeholder="Password"
            onChange={(e)=>setPassword(e.target.value)}
          />
          {error && <div className="errorSquare">{error}</div>}
          <div id="buttons">
            <button type="submit" onClick={onLogin} >Log In</button>
          </div>
        </form>
      </div>
    );
};

export default Login;