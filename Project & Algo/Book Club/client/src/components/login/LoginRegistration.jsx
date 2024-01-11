import React, { useState } from 'react'
import './LoginRegistration.css'
import logoCliad from './Assets/logo-removebg-preview.png'
const LoginRegistration = () => {



  return (
    <div className='container'>
    <div className='body-style'>
    <div className="wrapper">
        <span className="bg-animate"></span>
        <div className="form-box login">
            <h2>Login</h2>
            <form action="#">
                <div className="input-box">
                    <input type="text" required />
                    <label >UserName</label>
                </div>
                <div className="input-box">
                    <input type="password" required />
                    <label >Password</label>
                </div>
                <button type="submit" className="btn-Login">Login</button>
            </form>
        </div>
        <div className="info-text login">
            <img src={logoCliad} alt="logo CLIAD" />
        </div>
    </div></div></div>
  )
}

export default LoginRegistration