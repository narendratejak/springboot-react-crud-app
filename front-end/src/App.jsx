import { useState } from 'react'

import './App.css'
import ListUserCompoent from './components/ListUserCompoent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import UserComponent from './components/UserComponent'



function App() {
  const [count, setCount] = useState(0)

  

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
      <Route path='/' element={<ListUserCompoent/>}></Route>
      <Route path='/users' element={<ListUserCompoent/>}></Route>
      <Route path ='/add-user' element={<UserComponent/>}></Route>
      <Route path ='/edit-user/:id' element={<UserComponent/>}></Route>

    </Routes>
   
     <FooterComponent/>
     </BrowserRouter>
    </>
  )
}

export default App
