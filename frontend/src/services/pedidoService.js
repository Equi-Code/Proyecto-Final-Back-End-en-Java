import api from "./api";

export async function crearPedido(pedido) {

    const response = await api.post("/pedidos", pedido);

    return response.data;

}

export async function obtenerPedidos() {

    const response = await api.get("/pedidos");

    return response.data;

}

export async function obtenerPedido(id) {

    const response = await api.get(`/pedidos/${id}`);

    return response.data;

}

export async function cambiarEstado(id, estado) {

      console.log({
        id,
        estado
    });

    const response = await api.patch(

        `/pedidos/${id}/estado`,
        { estado }

    );

    return response.data;

}

export async function eliminarPedido(id) {

    await api.delete(`/pedidos/${id}`);

}