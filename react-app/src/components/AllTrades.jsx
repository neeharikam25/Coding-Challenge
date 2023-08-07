import React from "react";
import TradeDetails from "./TradeDetails";
import Row from "react-bootstrap/Row";
import { useState, useEffect } from "react";
import { getAllTrades } from "../services/TradeServices";
import { Link, useNavigate, useLocation, useParams } from "react-router-dom";
import Navigation from "./Navigation";
import FakeTradeDetails from "./FakeTradeDetails";

const AllTrades = () => {

  const fakeTradeDetails = {
    trade_id: "ID",
    trade_settlement_date: "Trade settlement date",
    trade_date: "Trade date",
    status: "Status",
    currency: "Currency",
    unit_price: "Unit price",
    type: "Type",
    quantity: "Quantity",
    counterparty: "Counterparty",
    isin: "ISIN",
    book: "Tradebook ID"
  };

  const { state } = useLocation();


  const [trades, setTrades] = useState([]);

  useEffect(() => {
    getTradesFromAPI();
  }, []);

  const getTradesFromAPI = () => {
    getAllTrades(state.securityId)
      .then((res) => {
        setTrades(res.data);
      })
      .catch((err) => {
        setTrades([]);
        console.log(err);
      });
  };
  return (
    <div style={{backgroundColor:"#f8f9fa"}}>

      <Navigation email={state.email} />

      <div className="list-bonds" style={{backgroundColor:"#f8f9fa"}}>
        <div className="trades-center">
          <Row className="bond-column">
            {trades.length > 0 ? (
              <>
                <table class="styled-table">
                  <thead>
                    <FakeTradeDetails info={fakeTradeDetails} />
                  </thead>
                  <tbody>
                    {trades.map((trade) => (
                      <TradeDetails
                        info={trade}
                        isin={state.isin}
                        book={state.book}
                        key={trade.trade_id}
                      />
                    ))}
                  </tbody>
                </table>
              </>
            ) : (
              <>{<h1>There are no trades in this bond</h1>}</>
            )}
          </Row>
        </div>
      </div>
    </div>
  );
};

export default AllTrades;
