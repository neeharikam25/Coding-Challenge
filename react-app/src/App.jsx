import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Routes, Route } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import AllBonds from './components/AllBonds'
import AllTrades from "./components/AllTrades";
import LoginPage from './components/LoginPage'
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'

function App() {
  return (
    <>
    <LocalizationProvider dateAdapter={AdapterDayjs}>
    
        <Routes>
        <Route path="/" element={ <> <LoginPage/> </>} />

          <Route path="/allBonds" element={<AllBonds/>} />
          <Route path='/seeTrades' element={<AllTrades/>}/>

        </Routes>
    </LocalizationProvider>
    </>
  );
}

export default App;
