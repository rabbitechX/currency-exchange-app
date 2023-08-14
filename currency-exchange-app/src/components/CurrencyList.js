import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Currency.css';

const CurrencyList = () => {
  const [currencies, setCurrencies] = useState([]);

  useEffect(() => {
    const fetchCurrencies = async () => {
      try {
//        const response = await fetch('https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e'); // 'API_URL'
        const response = await fetch('http://localhost:8080/currency?usedb=true'); // 'API_URL'
        const data = await response.json();
        setCurrencies(data);
      } catch (error) {
        console.error('Chyba při získávání dat:', error);
      }
    };

    fetchCurrencies();
  }, []);

  return (
    <div className="Currency">
      <h2>Currency List</h2>
      <center>
      <table>
      <thead>
      <tr>
        <th>Currency</th>
        <th>Country</th>
        <th>Short</th>
        <th>Sell</th>
        <th>Mid</th>
        <th>Buy</th>
        <th>Link</th>
      </tr>
      </thead>
      <tbody> 
        {currencies.map((currency) => (
          <tr key={currency.shortName}>
            <td>{currency.name}</td>
            <td>{currency.country}</td>
            <td>{currency.shortName}</td>
            <td>{currency.currSell}</td>
            <td>{currency.currMid}</td>
            <td>{currency.currBuy}</td> 
            <td><Link to={`/currency/${currency.shortName}`}>Detail</Link></td>
          </tr>
        ))}
      </tbody>
      </table>
      </center>
    </div>
  );
};

export default CurrencyList;

