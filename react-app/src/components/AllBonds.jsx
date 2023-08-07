
import React from 'react'
import BondDetails from './BondDetails'
import Row from 'react-bootstrap/Row'
import { useState, useEffect } from 'react'
import { Link, useNavigate, useLocation, useParams } from 'react-router-dom';
import { getAllBonds } from '../services/BondServices'
import { getUserId } from '../services/UserServices'
import { auth } from '../config/firebase'
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
  const [email, setEmail] = useState('')
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
  }, []);

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
      <table className="table table-hover table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col" colspan="3">Maturity date</th>


        </tr>
      </thead>
      <tbody>
        {bonds.length > 0 ? (
<>{
          bonds.map((bond, index) => {
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
            <tr key={bond.securityId}>
              <th scope="row" style={{width: "100px", height: "200px;"}}>Bond {bond.securityId}</th>
              <td>{bond.bondMaturityDate}</td>
              <td>{bond.last}</td>
              <td className="container_new">
                <BondDetails info={bond} email={state.email}/>
              </td>
            </tr>
          );})}</>
        ) : (
<>
          <tr>
            <td colSpan="4">
              <h1>Sorry, you have no bonds</h1>
            </td>
          </tr>
</>
        )}
      </tbody>
    </table>
    </>
)}

export default AllBonds;

