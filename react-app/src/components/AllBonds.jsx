import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { Link, useNavigate,useLocation,useParams } from 'react-router-dom';
import { getAllBonds } from '../services/BondServices'
import {getUserId} from '../services/UserServices'
import {auth} from '../config/firebase' 

const AllBonds = () => {

  const [items, setItems] = useState([]);
 

const [bonds,setBonds] = useState([]);
const [uid,setUid]=useState('');
const { state } = useLocation();
const [email,setEmail]=useState('')
useEffect(() => {
  setItems(JSON.parse(localStorage.getItem('email')));

  console.log(items[0]);
  const fetchData = async () => {
    try {
      const userIdResponse = await getUserId(state.email);
      const userId = userIdResponse.data;
      setUid(userId);
      console.log(userId);

      const bondsResponse = await getAllBonds(userId);
      const bondsData = bondsResponse.data;
      setBonds(bondsData);
    } catch (error) {
      console.error('Eroare:', error);
      setBonds([]);
    }
  };

  fetchData();
}, []);






        return (
          <>
          <div className='list-bonds'>
           <div className='bonds-center'>
            <Row className='bond-column'>
            {bonds.length>0?
            <>{bonds.map((bond) => (
                  <div className='container' key={bond.securityId}>
                    <BondDetails info={bond}  />
                  </div>
                ))}
                </>:
                <>{<h1>Sorry you have no bonds</h1>}</>} 
            </Row>
            </div>
            </div>
          </>
        )


    }

    

export default AllBonds