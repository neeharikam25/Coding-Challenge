import React from "react";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { useState, useEffect } from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { getAllTrades, getTradesCP } from "../services/TradeServices";

const FakeTradeDetails = (props) => {

  return (
    // <div className="list-bonds">
    //   <div className="bonds-center">
    //     <Row className="bond-column">
              <tr>
                <td>{props.info.trade_id}</td>
                <td>{props.info.trade_settlement_date}</td>
                <td>{props.info.trade_date}</td>
                <td style={{ color: "#008000" }}>{props.info.status}</td>
                <td>{props.info.currency}</td>
                <td>{props.info.unit_price}</td>
                <td>{props.info.type}</td>
                <td>{props.info.quantity}</td>
                <td>{props.info.counterparty}</td>
              </tr> 
    //     </Row>
    //   </div>
    // </div>
  );
};

export default FakeTradeDetails;
