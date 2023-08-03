import React from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getAllBonds } from '../services/BondServices'
import { Navigate } from 'react-router-dom';




const BondDetails = (props ) => {
  const[counter, setCounter] = useState(0);
//   useEffect(()=>{
//     getDogFromAPI();}, 
//     []
//   );
 

  const [ok,setOk]=useState(false)
  
  /*
  const getDogFromAPI = (arg)=>{
    getOwner(arg)
    .then(res => {
        setOwner(res.data);
        console.log(res.data)
        setOk(true)
    })
    .catch(err => {
        
        console.log(err);
    })
  }*/

  const showMore=()=>
  {
    console.log(props.info.bondMaturityDate);
    setOk(!ok);
  }

  const navig=()=>{

  }

  return (
    <Card className='bond'>

    <Card.Body >
    <Card.Title className='cardHover' >Bond</Card.Title>
      <Card.Title >Maturity date: {props.info.bondMaturityDate}</Card.Title>
      
      <Row className='category-bold'>
        <Col><Button className='btn' style={{backgroundColor:'#0a0a23'}} onClick={()=>{showMore()}}>{ok==false? "Show more" : "Show less"}</Button></Col>
        {ok==true ?
        <><Col><Card.Text >ISIN: {props.info.isin}</Card.Text > </Col>
        <Col><Card.Text >CUSIP: {props.info.cusip}</Card.Text > </Col>
        <Col><Card.Text >ISSUER: {props.info.issuerName}</Card.Text > </Col></>
        :
        <>
        </>}
        
      </Row>
      
    <Button className="btn" onClick={()=>{navig(props.info.securityId)}}>Show trades</Button>
    </Card.Body>
  </Card>
  )
}

export default BondDetails