import api from "./api";

export async function obtenerProductos() {

    const response = await api.get("/productos");

    return response.data;

}