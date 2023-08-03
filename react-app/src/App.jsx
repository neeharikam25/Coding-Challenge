import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes } from "react-router-dom";

import Navigation from "./components/Navigation";

function App() {
  return (
    <>
      <Navigation />
      <Routes></Routes>
    </>
  );
}

export default App;
