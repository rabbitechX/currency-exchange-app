import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';
import './Currency.css';

const CurrencyDetail = () => {
  const { shortName } = useParams();
  const [currency, setCurrency] = useState(null);

  useEffect(() => {
    const fetchCurrency = async () => {
      try {
//        const response = await fetch('https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e'); // 'API_URL'
        const response = await fetch('http://localhost:8080/currency?usedb=true'); // 'API_URL'
        const data = await response.json();
        const currency = data.find((c) => c.shortName === shortName);
        setCurrency(currency);
      } catch (error) {
        console.error('Chyba při získávání dat:', error);
      }
    };

    fetchCurrency();
  }, [shortName]);

  if (!currency) {
    return <div className="Currency">Loading...</div>;
  }

  return (
    <div className="Currency">
      <h2>Currency Detail</h2>
      <p>
        Currency: {currency.name}<br/>
        Country: {currency.country}<br/>
        Short Name: {currency.shortName}
      </p>
      
      <p>
        Curr Sell: {currency.currSell}<br/>
        Curr Mid: {currency.currMid}<br/>
        Curr Buy: {currency.currBuy}
      </p>
      
      <p>
        Valute Sell: {currency.valSell}<br/>
        Valute Mid: {currency.valMid}<br/>
        Valute Buy: {currency.valBuy}
      </p>
      
      <p>
        CNB Mid: {currency.cnbMid}<br/>
        ECB Mid: {currency.ecbMid}
      </p>

      <Link to={`/`}>Back</Link>
    </div>
  );
};

export default CurrencyDetail;

