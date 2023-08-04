import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { Link, useNavigate,useLocation,useParams } from 'react-router-dom';
import { getAllBonds } from '../services/BondServices'
import {getUserId} from '../services/UserServices'
const AllBonds = () => {


const [bonds,setBonds] = useState([]);
const [uid,setUid]=useState('');
const { state } = useLocation();
// useEffect(()=>{
  
// getUserIdFromAPI();
// },
//   []
// );

useEffect(() => {
  const getUserIdFromAPI= async ()=>{
    console.log(state.email);
  getUserId(state.email)
  .then(res=>{setUid(res.data);
  console.log(uid);
  })
  .catch(err => {
    setBonds([]);
    console.log(err);
  })
  }

  const getBondsFromAPI = async ()=>{
    getAllBonds(uid)
    .then(res => {
        setBonds(res.data);
    })
    .catch(err => {
        setBonds([]);
        console.log(err);
    })
  }

  getUserIdFromAPI().then(getBondsFromAPI);
  }, []);







        return (
          <>
          <div className='list-bonds'>
           <div className='bonds-center'>
            <Row className='bond-column'>
            {bonds.map(bond => (
                  <div className='container' key={bond.securityId}>
                    <BondDetails info={bond}  />
                  </div>
                ))} 
            </Row>
            {uid}
            </div>
            </div>
          </>
        )


    }

    

export default AllBonds