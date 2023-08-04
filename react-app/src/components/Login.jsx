import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { Navigate,useNavigate } from 'react-router-dom';
import { ToastContainer,toast } from "react-toastify";
import { signInWithEmailAndPassword } from "firebase/auth";
import {auth} from '../config/firebase' 

const Login = () => {
  // const [data, setData] = useState({
  //   email: "",
  //   password: "",
  // });
  const [error, setError] = useState("");
  const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

  // const handleChange = ({ currentTarget: input }) => {
  //   setData({ ...data, [input.name]: input.value });
  // };

  const handleSubmit = async () => {
    if(email===""||password===""){
      toast.error('Email and password are req');
    }
    try{
      await signInWithEmailAndPassword(auth,email,password).then(()=>{
        navigate('/allbonds');
      })
    }
    catch(err){
      if(err.code==='auth/invalid-email'){
        toast.error('Invalid email id')
      }
      if(err.code==='auth/user-not-found'){
        toast.error('Please check your email')
      }
      if(err.code==='auth/wrong-password'){
        toast.error('Please check your password')
      }
      if(err.code==='auth/too-many-requests'){
        toast.error('Too many attempts, try again later')
      }
    }

  };


 
  return (
    <div id="login">
      <h1>Log In</h1>
      <form id="form-container" onSubmit={handleSubmit}>
        <label htmlFor="username">Email</label>
        <input
         type="text"
         placeholder="Email"
         value={email}
         onChange={(e) => setEmail(e.target.value)}
        />
        <label htmlFor="password">Password</label>
        <input
           type="password"
           placeholder="Password"
           value={password}
           onChange={(e) => setPassword(e.target.value)}
        />
        {error && <div className="errorSquare">{error}</div>}
        <div id="buttons">
          <button type="submit" onClick={handleSubmit}>Log In</button>
        </div>
      </form>
    </div>
  );
};

export default Login;