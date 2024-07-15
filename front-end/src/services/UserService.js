import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/user';

export const lsitOfEmployees = () => {
    return axios.get(REST_API_BASE_URL+"/all");
}

export const addUser = (user) => {
    return axios.post(REST_API_BASE_URL,user);
}

export const getUserByid = (id) => {
    return axios.get(REST_API_BASE_URL+"/getUser/"+id);
}

export const updateUser = (id,user) => {
    return axios.put(REST_API_BASE_URL+"/update/"+id,user);
}

export const deleteUserById = (id) => {
    return axios.delete(REST_API_BASE_URL+"/delete/"+id);
}