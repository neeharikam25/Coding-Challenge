import React from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getAllBonds } from '../services/BondServices'
import { Navigate,useNavigate, useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';

const BondDetails = (props ) => {


  const [showMoreInfo, setShowMoreInfo] = useState(false);

  const email_string =  props.email;


  const showMore = () => {
    setShowMoreInfo(!showMoreInfo);
  };


const navigate=useNavigate();

  return (
    <Card id='bond'>

    <Card.Body style={{ minHeight: showMoreInfo ? '160px' : '80px', flexDirection: "column",justifyContent:"space-between", display: "flex" }}>

      <Row className='category-bold'>
        <Col md={6}>
          <Button className="btn login_btn" onClick={showMore} id='btnn'>
              {showMoreInfo ? 'Show less' : 'Show more'}</Button></Col>
              <Col md={6} className="text-right">
            <Button
              className="btn login_btn btn-show-trades"
              id='btnn'
              onClick={() => {
                // Navigate to '/seeTrades' with the 'securityId' as a parameter
                navigate('/seeTrades', { state: { securityId: props.info.securityId , book:props.info.securityId,isin:props.info.isin,
                email:email_string } });
              }}
            >
              Show trades
            </Button>
          </Col>
      </Row>

      {showMoreInfo && (
          <div className="additional-info">
            <Card.Text>ISIN: {props.info.isin}</Card.Text>
            <Card.Text>CUSIP: {props.info.cusip}</Card.Text>
            <Card.Text>ISSUER: {props.info.issuerName}</Card.Text>
          </div>
        )}

</Card.Body>
    </Card>
  );
};



export default BondDetails