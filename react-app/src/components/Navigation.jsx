import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import Container from "react-bootstrap/Container";
import { signOut } from "firebase/auth";
import { auth } from "../config/firebase";
import { useNavigate } from "react-router-dom";
import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";

const Navigation = (props) => {
  const [activeUrl, setActiveUrl] = useState("");
  const [items, setItems] = useState([]);

  



  // useEffect(() => {
  //   if (activeUrl !== "/") {
  //     setItems(JSON.parse(localStorage.getItem("email")));
  //   }
  // }, []);

  const handleLogout = () => {
    signOut(auth)
      .then(() => {
        // Sign-out successful.
        localStorage.removeItem("email");
        //localStorage.clear();
        navigate("/");
        console.log("Signed out successfully");
      })
      .catch((error) => {
        // An error happened.
      });
  };

  const appLocation = useLocation();
  const navigate = useNavigate();
  useEffect(() => {}, []);

  useEffect(() => {
    setActiveUrl(window.location.pathname);
  }, [appLocation]);


  return (
    <div className="App">
      {activeUrl !== "/" ? (
        <>
          <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
              <Navbar.Text href="/">Hello, {props.email}!</Navbar.Text>

              <Navbar.Brand>My Bonds App</Navbar.Brand>

              <div id="navbar_buttons">
                <Button
                  className="btn login_btn"
                  id="button-55"
                  onClick={handleLogout}
                >
                  {" "}
                  Sign out{" "}
                </Button>

                {/* add the second button ( Go back to Main Page ) only if we are not in the main page */}
                {activeUrl !== "/allBonds" ? (
                  <Button
                    class="back_btn"
                    onClick={() => {
                      navigate("/allBonds", { state : { email : props.email }});
                    }}
                  >
                    {" "}
                    Back to Main Page{" "}
                  </Button>
                ) : (
                  <></>
                )}
              </div>
            </Container>
          </Navbar>
        </>
      ) : (
        <></>
      )}
    </div>
  );
};

export default Navigation;
