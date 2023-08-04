import React from "react";
import BondDetails from "./BondDetails";
import Row from "react-bootstrap/Row";
import { useState, useEffect } from "react";
import { getAllBonds } from "../services/BondServices";
import { DatePicker } from "@mui/x-date-pickers";
import dayjs from "dayjs";
import { differenceInDays } from "date-fns";
import { Button } from "@mui/material";

const AllBonds = () => {
  const [bonds, setBonds] = useState([]);
  const [firstChange, setFirstChange] = useState(false);

  //const [value, setValue] = useState(new Date(2021, 0, 3, 0, 0, 0));

  const [value, setValue] = useState();

  const handlerChange = (newValue) => {
    setValue(newValue.$d);
    setFirstChange(true);
  };

  useEffect(() => {
    console.log(value);
  }, [value]);

  useEffect(() => {
    getBondsFromAPI();
  }, []);

  const getBondsFromAPI = () => {
    getAllBonds()
      .then((res) => {
        setBonds(res.data);
      })
      .catch((err) => {
        setBonds([]);
        console.log(err);
      });
  };

  return (
    <>
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
            {bonds.map((bond) => {
              if (
                firstChange === false ||
                (differenceInDays(new Date(bond.bondMaturityDate), value) <=
                  5 &&
                  differenceInDays(new Date(bond.bondMaturityDate), value) >=
                    0) ||
                (differenceInDays(new Date(bond.bondMaturityDate), value) >=
                  -5 &&
                  differenceInDays(new Date(bond.bondMaturityDate), value) <= 0)
              )
                return (
                  <div className="container" key={bond.securityId}>
                    <BondDetails info={bond} />
                    {console.log(
                      differenceInDays(new Date(bond.bondMaturityDate), value)
                    )}
                  </div>
                );

              return <div key={bond.securityId}></div>;
            })}
          </Row>
        </div>
      </div>
    </>
  );
};

export default AllBonds;
