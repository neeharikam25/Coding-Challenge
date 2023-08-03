import React from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getAllBonds } from '../services/BondServices'
import { Navigate,useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';



const BondDetails = (props ) => {

 
  const [ok,setOk]=useState(false)
  
  const showMore=()=>
  {
    console.log(props.info.bondMaturityDate);
    setOk(!ok);
  }

  const functie=()=>{
    console.log(props.info.securityId);
  }
const navigate=useNavigate();

  return (
    <Card id='bond'>

    <Card.Body >
    <Card.Title className='cardHover' >Bond</Card.Title>
      <Card.Title >Maturity date: {props.info.bondMaturityDate}</Card.Title>
      
      <Row className='category-bold'>
        <Col><Button id='btnn'  onClick={()=>{showMore()}}>{ok==false? "Show more" : "Show less"}</Button></Col>
        {ok==true ?
        <><Col><Card.Text >ISIN: {props.info.isin}</Card.Text > </Col>
        <Col><Card.Text >CUSIP: {props.info.cusip}</Card.Text > </Col>
        <Col><Card.Text >ISSUER: {props.info.issuerName}</Card.Text > </Col>
        <Col><Card.Text >ID: {props.info.securityId}</Card.Text > </Col></>
        
        :
        <>
        </>}
        
      </Row>
      
    <Button
        id='btnn'
        onClick={() => {
          // Navigate to '/seeTrades' with the 'securityId' as a parameter
          navigate('/seeTrades', { state: { securityId: props.info.securityId } });
        }}
      >
        Show trades
      </Button>
    </Card.Body>
  </Card>
  )
}

export default BondDetails