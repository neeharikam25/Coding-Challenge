import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Routes, Route } from 'react-router-dom';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import AllBonds from "./components/AllBonds";

function App() {
  return (
    <>
    


      
        <Routes>
          <Route path="allbonds" element={<AllBonds/>} />
          <Route path="/" element={<AllBonds/>} />
        </Routes>
      
    </>
  );
}

export default App;
