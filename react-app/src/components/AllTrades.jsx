import React from "react";
import TradeDetails from "./TradeDetails";
import Row from "react-bootstrap/Row";
import { useState, useEffect } from "react";
import { getAllTrades } from "../services/TradeServices";
import { Link, useNavigate, useLocation, useParams } from "react-router-dom";
import  Navigation  from "./Navigation";
import FakeTradeDetails from "./FakeTradeDetails";

const AllTrades = () => {


  const fakeTradeDetails = {
    trade_id: "id",
    trade_settlement_date: "trade settlement date",
    trade_date: "trade date",
    status : "status" ,
    currency: 	"currency",
    unit_price: "unit price",
    type : "type" ,
    quantity: "quantity",
    counterparty: "counterparty"
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
    <>
      <Navigation email={state.email} />
      <h4 class="trades-header"> Trades Detail</h4>
      <div className="list-bonds">
        <div className="bonds-center">
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
    </>
  );
};

export default AllTrades;
