import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { getAllBonds } from '../services/BondServices'
import { DatePicker } from '@mui/x-date-pickers'

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
    <DatePicker label="Bond Maturity Date" />
    <div className='list-bonds'>
      <div className='bonds-center'>
      <Row className='bond-column'>
        {bonds.map(bond => (
            <div className='container' key={bond.securityId}>
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