import React from "react";
import TradeDetails from "./TradeDetails";
import Row from "react-bootstrap/Row";
import { useState, useEffect } from "react";
import { getAllTrades } from "../services/TradeServices";
import { Link, useNavigate, useLocation, useParams } from "react-router-dom";
import  Navigation  from "./Navigation";

const AllTrades = () => {
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
      <Navigation email={state.email}  />
      <h4 class='trades-header'> Trades Detail</h4>
      <div className="list-bonds">
        <div className="bonds-center">
          <Row className="bond-column">
            {trades.length > 0 ? (
              <>
              <table class='styled-table'>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>trade settlement date</th>
                        <th>trade date</th>
                        <th>status</th>
                        <th>currency</th>
                        <th>unit price</th>
                        <th>type</th>
                        <th>quantity</th>
                        <th>counter party</th>
                    </tr>
                </thead>
              </table>
                {trades.map((trade) => (
                  <div className="container" key={trade.trade_id}>
                    <TradeDetails info={trade} isin={state.isin} book={state.book} />
                  </div>
                ))}
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
