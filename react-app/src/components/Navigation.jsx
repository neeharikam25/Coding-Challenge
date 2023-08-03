import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";

const Navigation = () => {
  const [activeUrl, setActiveUrl] = useState("");
  const appLocation = useLocation();

  useEffect(() => {
    setActiveUrl(window.location.pathname);
  }, [appLocation]);

  console.log(activeUrl);

  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Heroes</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home">All Heroes</Nav.Link>
            <Nav.Link href="#link">Add Hero</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
      <Button id="sign-out"> Sign out </Button>

      {/* add the second button ( Go back to Main Page ) only if we are not in the main page */}
      {activeUrl === "/" ? (
        <Button id="sign-out"> Back to Main Page </Button>
      ) : (
        <></>
      )}
    </Navbar>
  );
};

export default Navigation;
