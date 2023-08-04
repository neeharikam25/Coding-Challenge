import { Navigate, useNavigate } from 'react-router-dom';
import React, { useState } from "react";
import { signInWithEmailAndPassword } from "firebase/auth";
import {auth} from '../config/firebase' 

const LoginPage = () => {
    const containerStyle = {
        height: '100vh',
        backgroundImage: 'url("https://static.ffx.io/images/$zoom_0.146%2C$multiply_4%2C$ratio_1.5%2C$width_756%2C$x_0%2C$y_29/t_crop_custom/c_scale%2Cw_620%2Cq_88%2Cf_auto/86aec8dfdd017af4714a31257b4b68268512eed8")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
      };

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
        navigate("/allbonds")
        console.log(user);
    })
    .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log(errorCode, errorMessage)
    });}
    return (
        <div style={containerStyle}>
        <div className="container h-100">
            <div className="d-flex justify-content-center h-100">
                <div className="user_card">
                    <div className="d-flex justify-content-center">
                        <h3 id="form-title">LOGIN</h3>
                    </div>
                    <div className="d-flex justify-content-center form_container">
                        <form >
                            <div className="input-group mb-3">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="username"   required                                                                                
        placeholder="Email address"
        onChange={(e)=>setEmail(e.target.value)} className="form-control" />
                            </div>
                            <div className="input-group mb-2">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="password" required                                                                                
            placeholder="Password"
            onChange={(e)=>setPassword(e.target.value)} className="form-control" />
                            </div>
                            <div className="d-flex justify-content-center mt-3 login_container">
                                <button className="btn login_btn" type="submit" onClick={onLogin}>SIGN IN</button>
                            </div>
                        </form>
                    </div>
                    <div className="mt-4">
                        <div className="d-flex justify-content-center links">
                            <a href="/password_reset" className="ml-2">Forgot Password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    );
};

export default LoginPage;