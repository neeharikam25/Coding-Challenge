import React from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getAllTrades } from '../services/TradeServices'




const BondDetails = (props ) => {
  const[counter, setCounter] = useState(0);
 
 

  const [ok,setOk]=useState(false)
  

  return (
    <Card className='bond'>

    <Card.Body >
    <Card.Title >Trade</Card.Title>
      <Card.Title >Trade settlement date: {props.info.trade_settlement_date}</Card.Title>
      <Card.Title >Trade date: {props.info.trade_date}</Card.Title>
      <Card.Title >Currency: {props.info.currency}</Card.Title>
      <Card.Title >Counterparty id: {props.info.counterparty_id}</Card.Title>
      
    
    </Card.Body>
  </Card>
  )
}

export default BondDetails