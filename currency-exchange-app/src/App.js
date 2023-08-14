import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import CurrencyList from './components/CurrencyList';
import CurrencyDetail from './components/CurrencyDetail';

const App = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={CurrencyList} />
        <Route path="/currency/:shortName" component={CurrencyDetail} />
      </Switch>
    </Router>
  );
};

export default App;

