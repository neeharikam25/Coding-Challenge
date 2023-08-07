import React, { useState } from 'react';
import { Card, Button, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const BondDetails = (props) => {
  const [showMoreInfo, setShowMoreInfo] = useState(false);
  const navigate = useNavigate();

  const showMore = () => {
    setShowMoreInfo(!showMoreInfo);
  };

  return (
    <Card>
      <Card.Body  style={{ minHeight: showMoreInfo ? '160px' : '80px', flexDirection: "column",justifyContent:"space-between", display: "flex" }}>
        <Card.Title className='cardHover'></Card.Title>
        <Card.Title></Card.Title>

        <Row className='category-bold'>
          <Col md={6}>
            <Button className="btn login_btn" onClick={showMore} id='btnn'>
              {showMoreInfo ? 'Show less' : 'Show more'}
            </Button>
          </Col>
          <Col md={6} className="text-right">
            <Button
              className="btn login_btn btn-show-trades"
              id='btnn'
              onClick={() => {
                // Navigate to '/seeTrades' with the 'securityId' as a parameter
                navigate('/seeTrades', { state: { securityId: props.info.securityId } });
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

export default BondDetails;
