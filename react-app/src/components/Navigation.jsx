import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import Container from "react-bootstrap/Container";

import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import { Navigate,useNavigate } from 'react-router-dom';

const Navigation = () => {
  const [activeUrl, setActiveUrl] = useState("");

  const appLocation = useLocation();
  const navigate=useNavigate();
  useEffect(() => {}, []);

  useEffect(() => {
    setActiveUrl(window.location.pathname);
  }, [appLocation]);

  console.log(activeUrl);

  return (
    <div className="App">
    {activeUrl!=="/"?<>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        {/* <Card.Text
          style={{
            fontSize: "20px",
            marginLeft: "15%",
            marginRight: "15%",
            whiteSpace: "nowrap",
          }}
        >
          {" "}
          Hello, user!
        </Card.Text> */}

        <Navbar.Text href="/">Hello, user!</Navbar.Text>

        <Navbar.Brand href="/">My Bonds App</Navbar.Brand>

        <div id="navbar_buttons">
          <Button id="signout_button"> Sign out </Button>

          {/* add the second button ( Go back to Main Page ) only if we are not in the main page */}
          {activeUrl !== "/allBonds" ? (
            <Button id="back_button"   onClick={() => {
              navigate('/allBonds');
            }}> Back to Main Page </Button>
          ) : (
            <></>
          )}
        </div>
      </Container>
    </Navbar>
    </>
    :
    <>
    </>
    }
    </div>
  );
};

export default Navigation;
