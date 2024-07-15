import React, { useEffect, useState } from 'react'
import { deleteUserById, lsitOfEmployees } from '../services/UserService';
import {useNavigate} from 'react-router-dom'

const ListUserCompoent = () => {

    // const dummyData = [

    //     {

    //         "id" : 1,
    //     "firstName" : "Teja",
    //     "lastName" : "Narnera",
    //     "email" : "teja@gmail.com"

    //     },
    //     {

    //         "id" : 2,
    //     "firstName" : "Teja2",
    //     "lastName" : "Narnera",
    //     "email" : "teja@gmail.com"

    //     },
    //     {

    //         "id" : 3,
    //     "firstName" : "Teja3",
    //     "lastName" : "Narnera",
    //     "email" : "teja@gmail.com"

    //     }
        
    // ]

    const [users, setusers] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {
        getAllEmployees();
    },[])

    function getAllEmployees(){
        lsitOfEmployees().then((response) => {
            console.log(response.data);
            setusers(response.data.usersList)
        }).catch(error =>{
            console.log(error);
        }
        )
    }

    const addNewEmployee = () =>{

        navigate('/add-user');

    }

    function updateUser(id){
        navigate(`/edit-user/${id}`);

    }

    function deleteUser(id){

        deleteUserById(id).then((res) => {
            console.log(res)
            getAllEmployees();
            navigate("/")
        }).catch((error) =>{
            console.log(error);
        })
       

    }

    console.log(users);
  return (
    <div className='container'>
        <h2 className='text-center'>List Of Users</h2>
        <button class="btn btn-primary mb-2" onClick={addNewEmployee}>Add  User</button>
        <table className="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    users.map(user => 
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.firstName}</td>
                            <td>{user.lastName}</td>
                            <td>{user.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={()=> updateUser(user.id)}>Update</button>
                                <button className='btn btn-danger' style={{marginLeft : '10px'}} onClick={()=> deleteUser(user.id)}>delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListUserCompoent