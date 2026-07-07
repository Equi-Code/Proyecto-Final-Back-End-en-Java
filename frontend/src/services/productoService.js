import api from "./api";


export async function obtenerProductos() {

    const response = await api.get("/productos");

    return response.data;

}

export async function obtenerProducto(id) {

    const response = await api.get(`/productos/${id}`);

    return response.data;

}

export async function obtenerIndumentaria() {

    const response = await api.get("/indumentaria");

    return response.data.content;

}

export async function obtenerAccesorios() {

    const response = await api.get("/accesorios");

    return response.data.content;

}