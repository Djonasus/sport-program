import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MainPage from './screens/MainPage';

import 'bootstrap/dist/css/bootstrap.min.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import ArticlesPage from './screens/ArticlesPage';
import ArticleDetailPage from './screens/ArticleDetailPage';

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
      </Routes>
    </Router>
  </React.StrictMode>
);