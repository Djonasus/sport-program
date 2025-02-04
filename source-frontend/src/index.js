import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MainPage from './screens/MainPage';

import 'bootstrap/dist/css/bootstrap.min.css';

import ArticlesPage from './screens/ArticlesPage';
import ArticleDetailPage from './screens/ArticleDetailPage';
import Maps from './screens/Map';
import Rank from './screens/Rank';
import LogPage from './screens/LogPage';
import RegPage from './screens/RegPage';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path='/' element={<MainPage/>}/>
        <Route path='/article' >
          <Route index element={<ArticlesPage />} />
          <Route path=':id' element={<ArticleDetailPage/>}/>
        </Route>
        <Route path='/maps' element={<Maps/>}/>
        <Route path='/rank' element={<Rank/>}/>
        <Route path='/login' element={<LogPage/>}/>
        <Route path='/reg' element={<RegPage/>}/>
      </Routes>
    </Router>
  </React.StrictMode>
);