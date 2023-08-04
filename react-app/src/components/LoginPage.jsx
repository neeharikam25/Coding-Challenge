import { useState } from "react";
import axios from "axios";
import { Navigate, useNavigate } from 'react-router-dom';


const LoginPage = () => {
    const containerStyle = {
        height: '100vh',
        backgroundImage: 'url("https://static.ffx.io/images/$zoom_0.146%2C$multiply_4%2C$ratio_1.5%2C$width_756%2C$x_0%2C$y_29/t_crop_custom/c_scale%2Cw_620%2Cq_88%2Cf_auto/86aec8dfdd017af4714a31257b4b68268512eed8")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
      };
    const [data, setData] = useState({
        username: "",
        password: "",
    });
    const [error, setError] = useState("");

    const handleChange = ({ currentTarget: input }) => {
        setData({ ...data, [input.name]: input.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const url = "http://localhost:8090/login";
            await axios.post(url, data);
            localStorage.setItem("token", data.username);
            window.location = "/";
        } catch (err) {
            if (
                err.response &&
                err.response.status >= 400 &&
                err.response.status <= 500
            ) {
                setError(err.response.data.message);
            }
        }
    };
    const navigate = useNavigate();
    return (
        <div style={containerStyle}>
        <div className="container h-100">
            <div className="d-flex justify-content-center h-100">
                <div className="user_card">
                    <div className="d-flex justify-content-center">
                        <h3 id="form-title">LOGIN</h3>
                    </div>
                    <div className="d-flex justify-content-center form_container">
                        <form onSubmit={handleSubmit}>
                            <div className="input-group mb-3">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="username" placeholder="Username..." className="form-control" />
                            </div>
                            <div className="input-group mb-2">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="password" placeholder="Password..." className="form-control" />
                            </div>
                            <div className="d-flex justify-content-center mt-3 login_container">
                                <button className="btn login_btn" type="submit" onClick={() => {
                                    navigate('/allBonds');
                                }}>SIGN IN</button>
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