import { hostNameUrl } from "../config/api";
import axios from "axios";



export function getAllTrades(id) {
    const trades = axios.get(`${hostNameUrl}/trades/security/${id}`);
  return trades;
}