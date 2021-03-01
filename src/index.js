import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './index.css';
import Welcome from './screens/welcome/welcome';
import Questions from './screens/questions/questions';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
     <BrowserRouter>
         <Switch>                                      
             <Route path="/" exact={true} component={Welcome}/>
             <Route path="/questions" component={Questions}/>
                    
         </Switch>
     </ BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);


reportWebVitals();
