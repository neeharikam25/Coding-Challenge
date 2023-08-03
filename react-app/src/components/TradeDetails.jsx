import React from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getAllTrades,getTradesCP } from '../services/TradeServices'




const TradeDetails = (props ) => {
  const[counter, setCounter] = useState(0);
 const [cp,setCp]=useState('');
 

  const [ok,setOk]=useState(false)
  useEffect(()=>{
    getCPFromAPI();}, 
    []
  );
  
  const getCPFromAPI = (arg)=>{
    getTradesCP(arg)
    .then(res => {
        setCp(res.data);
        console.log(res.data)
    })
    .catch(err => {
        
        console.log(err);
    })
  }
getCPFromAPI(props.info.counterparty_id);
  return (
    <Card id='bond'>

    <Card.Body >
    <Card.Title >Trade {props.info.trade_id}</Card.Title>
      <Card.Title >Trade settlement date: {props.info.trade_settlement_date}</Card.Title>
      <Card.Title >Trade date: {props.info.trade_date}</Card.Title>
      <Card.Title >Currency: {props.info.currency}</Card.Title>
      <Card.Title >Counter Party : {cp}</Card.Title>
      
    
    </Card.Body>
  </Card>
  )
}

export default TradeDetails