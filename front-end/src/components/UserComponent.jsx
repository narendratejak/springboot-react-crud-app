import React, { useEffect, useState } from 'react'
import { addUser, getUserByid, updateUser } from '../services/UserService';
import {useNavigate,useParams} from 'react-router-dom'
 
const UserComponent = () => {

    const [firstName,setFirstname]=useState('');
    const [lastName,setLasttname]=useState('');
    const [email,setEmail]=useState('');

    const navigate = useNavigate();
    const {id} =useParams();

    function pageTitle(){
        if(id){
            return <h2 className='text-center'> Update User</h2>
        }else{
            return <h2 className='text-center'> Add User</h2>
        }
    }

    useEffect(()=>{

        if(id){
            getUserByid(id).then((res) =>{
                setFirstname(res.data.firstName);
                setLasttname(res.data.lastName);
                setEmail(res.data.email);
            }).catch((error) =>{
                console.log(error);
            })
        }

    },[]
)


    

   
    function saveOrUpdateUser(e){
        const user = {firstName,lastName,email};
        console.log(user);

        e.preventDefault();

        if(validateForm()){

            if(id){
                updateUser(id,user).then((res) => {
                    console.log(res.data);
                    navigate('/users')
                }
            ).catch((error) =>{
                console.log(error)
            })

            }else{

                addUser(user).then((res) => {
                    console.log(res.data);
                    navigate('/users')
                }).catch((error) =>{
                    console.log(error);
                })

            }
            
       }
}

  const[errors,setErrors]=  useState({
        firstName : "",
        lastName : "",
        email : ""
    })

    function validateForm(){
        let valid = true;
        const errorsCopy = {...errors}

        if(firstName.trim()){
            errorsCopy.firstName='';

        }else{
            errorsCopy.firstName='First Name is Required';
            valid=false;
        }

        if(lastName.trim()){
            errorsCopy.lastName='';

        }else{
            errorsCopy.lastName='Last Name is Required';
            valid=false;
        }

        if(email.trim()){
            errorsCopy.email='';

        }else{
            errorsCopy.email='Email is Required';
            valid=false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    

  return (
    <div className='container'>
        <br></br>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                { pageTitle()}
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name</label>
                            <input 
                            type='text'
                            placeholder='enter user firstanme'
                            name='firstName'
                            value={firstName}
                            className={`form-control ${errors.firstName? 'is-invalid' : ''} ` }
                            onChange={(e) => setFirstname(e.target.value)}/>
                            {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
                        
                        <label className='form-label'>Last Name</label>
                            <input 
                            type='text'
                            placeholder='enter user last name'
                            name='lastName'
                            value={lastName}
                            className={`form-control ${errors.lastName? 'is-invalid' : ''} ` }
                            onChange={(e) => setLasttname(e.target.value)}/>
                            {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                        
                        <label className='form-label'>Email</label>
                        <input 
                            type='text'
                            placeholder='enter User Email'
                            name='email'
                            value={email}
                            className={`form-control ${errors.email? 'is-invalid' : ''} ` }
                            onChange={(e) => setEmail(e.target.value)}/>
                            {errors.email && <div className='invalid-feedback'>{errors.email}</div>}

                        </div>

                        <button className='btn btn-success' onClick={saveOrUpdateUser}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default UserComponent