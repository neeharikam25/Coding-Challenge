import { hostNameUrl } from "../config/api";
import axios from "axios";
import http from "axios";


export  function getUserId(id) {
  const uid = axios.get(`${hostNameUrl}/user/email/${id}`);
return uid;
}