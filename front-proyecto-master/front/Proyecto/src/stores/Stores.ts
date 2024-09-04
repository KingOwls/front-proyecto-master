import { writable } from 'svelte/store';


import axios from 'axios';
// Crea una store exportada para `show` con un valor inicial
export const show = writable(false);
export const rol = writable("admin");
export const showProdcts = writable(false);
export const showoduct = writable(false);
export const showPays = writable(false);
export const showOrder = writable(false);
export const showOffice = writable(false);
export const showCustomer = writable(false);
export const showUser = writable(false);

export const instance = axios.create({
 //  baseURL: 'http://54.86.124.70:8080/',
    baseURL: 'http://localhost:8091/',
  });
  
  instance.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    console.log(token);
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  }, (error) => {
    return Promise.reject(error);
  });
