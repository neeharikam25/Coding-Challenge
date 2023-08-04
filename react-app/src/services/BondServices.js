import { hostNameUrl } from "../config/api";
import axios from "axios";
import http from "axios";

export  function getAllBonds (id) {
  const bonds =  http.get(`${hostNameUrl}/security/user/${id}`);
  return bonds;
};


