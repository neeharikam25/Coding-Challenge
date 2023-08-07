
import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { Link, useNavigate,useLocation,useParams } from 'react-router-dom';
import { getAllBonds } from '../services/BondServices'
import {getUserId} from '../services/UserServices'
import {auth} from '../config/firebase' 
import { DatePicker } from "@mui/x-date-pickers";
import dayjs from "dayjs";
import { differenceInDays } from "date-fns";
import { Button } from "@mui/material";
import Navigation from "./Navigation";


const AllBonds = () => {
  const [bonds, setBonds] = useState([]);
  const [firstChange, setFirstChange] = useState(false);

  const [items, setItems] = useState([]);
 
  const [uid, setUid] = useState('');
  

  
  const { state } = useLocation();
  //console.log("STATE "  + state.email);

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

  const [value, setValue] = useState();

  const handlerChange = (newValue) => {
    setValue(newValue.$d);
    setFirstChange(true);
  };


  return (
    <>
      <Navigation email = {state.email }/>
      <DatePicker
        label="Bond maturity date"
        onChange={(newValue) => {
          handlerChange(newValue);
        }}
      />
      <Button
        className="btn back_btn"
        onClick={() => {
          setFirstChange(false);
        }}
      >
        {" "}
        See all Bonds!{" "}
      </Button>

      <div className="list-bonds">
        <div className="bonds-center">
          <Row className="bond-column">
            {bonds.length > 0 ? (
              <>
                {bonds.map((bond) => {
                  if (
                    firstChange === false ||
                    (differenceInDays(new Date(bond.bondMaturityDate), value) <=
                      5 &&
                      differenceInDays(
                        new Date(bond.bondMaturityDate),
                        value
                      ) >= 0) ||
                    (differenceInDays(new Date(bond.bondMaturityDate), value) >=
                      -5 &&
                      differenceInDays(
                        new Date(bond.bondMaturityDate),
                        value
                      ) <= 0)
                  )
                    return (
                      <div className="container" key={bond.securityId}>
                        <BondDetails info={bond} email={state.email}   />
                        {console.log(
                          differenceInDays(
                            new Date(bond.bondMaturityDate),
                            value
                          )
                        )}
                      </div>
                    );

                  return <div key={bond.securityId}></div>;
                })}
              </>
            ) : (
              <>{<h1>Sorry you have no bonds</h1>}</>
            )}
          </Row>
        </div>
      </div>
    </>
  );
};

export default AllBonds;

