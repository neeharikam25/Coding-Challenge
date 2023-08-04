import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Routes, Route } from 'react-router-dom';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import AllBonds from './components/AllBonds'
import AllTrades from "./components/AllTrades";
import Navigation from './components/Navigation'
import Login from './components/Login'
import LoginPage from './components/LoginPage'
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'

function App() {
  return (
    <>
    <LocalizationProvider dateAdapter={AdapterDayjs}>
    <Navigation></Navigation>
        <Routes>
        <Route path="/" element={<LoginPage/>} />
        <Route path="/allbonds" element={<AllBonds/>} />
        <Route path='/seeTrades' element={<AllTrades/>}/>
        </Routes>
    </LocalizationProvider>
    </>
  );
}

export default App;
