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
    <div className="list-bonds">
        <div className="bonds-center">
          <Row className="bond-column">
          <table className='styled-table'>
    <tbody>
        <tr>
            <td>{props.info.trade_id}</td>
            <td>{props.info.trade_settlement_date}</td>
            <td>{props.info.trade_date}</td>
            <td style={{ color: "#008000" }}>{props.info.status}</td>
            <td>{props.info.currency}</td>
            <td>{props.info.unit_price}</td>
            <td>{props.info.type}</td>
            <td>{props.info.quantity}</td>
            <td>{cp}</td>
        </tr>
    </tbody>
  </table>

          </Row>
          </div>
          </div>
    
  );
}

export default TradeDetails