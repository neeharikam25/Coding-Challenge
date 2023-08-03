import React from 'react'
import TradeDetails from './TradeDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { getAllTrades } from '../services/TradeServices'
import { Link, useNavigate,useLocation,useParams } from 'react-router-dom';

const AllTrades = (id) => {

const { state } = useLocation();
const [trades,setTrades] = useState([]);

useEffect(()=>{
  getTradesFromAPI();}, 
  []
);

const getTradesFromAPI = ()=>{
  getAllTrades(id)
  .then(res => {
      setTrades(res.data);
  })
  .catch(err => {
      setTrades([]);
      console.log(err);
  })
}
    
        return (
          <>
          <h1> Total count is: {trades.length}</h1>
          <div className='list-bonds'>
           <div className='bonds-center'>
            <Row className='bond-column'>
              {trades.map(trade => (
                  <div className='container' key={trade.trade_id}>
                    <TradeDetails info={trade}  />
                  </div>
                ))}
            </Row>
            </div>
            </div>
          </>
        )


    }

export default AllTrades