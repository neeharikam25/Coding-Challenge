import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { getAllBonds } from '../services/BondServices'

const AllBonds = () => {


const [bonds,setBonds] = useState([]);

useEffect(()=>{
  getBondsFromAPI();}, 
  []
);

const getBondsFromAPI = ()=>{
  getAllBonds()
  .then(res => {
      setBonds(res.data);
  })
  .catch(err => {
      setBonds([]);
      console.log(err);
  })
}
    
        return (
          <>
          <h1> Total count is: {bonds.length}</h1>
          <div className='list-bonds'>
           <div className='bonds-center'>
            <Row className='bond-column'>
              {bonds.map(bond => (
                  <div className='container' key={bond.bond_id}>
                    <BondDetails info={bond}  />
                  </div>
                ))}
            </Row>
            </div>
            </div>
          </>
        )


    }

export default AllBonds