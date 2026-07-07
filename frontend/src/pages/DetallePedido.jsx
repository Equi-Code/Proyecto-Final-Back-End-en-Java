import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

import { obtenerPedido } from "../services/pedidoService";
import { cambiarEstado } from "../services/pedidoService";
import "../css/Pedidos.css";

export default function DetallePedido() {

    const { id } = useParams();

    const [pedido, setPedido] = useState(null);

    async function actualizarEstado(e) {

        try {

            const nuevoEstado = e.target.value;

            const actualizado = await cambiarEstado(
                pedido.id,
                nuevoEstado
            );

            setPedido(actualizado);

        } catch (error) {

            console.error(error);

            alert("No se pudo actualizar el estado del pedido.");

        }

    }

    useEffect(() => {

        async function cargar() {

            const data = await obtenerPedido(id);

            setPedido(data);

        }

        cargar();

    }, [id]);

    if (!pedido)
        return <h2 className="pedidos-cargando">Cargando...</h2>;

    return (

        <div className="detalle-pedido-container">

            <h2>Pedido #{pedido.id}</h2>

            <div className="detalle-pedido-info">

                <p>

                    <strong>Estado:</strong>

                    <select
                        className="select-estado"
                        value={pedido.estado}
                        onChange={actualizarEstado}
                    >

                        <option value="PENDIENTE">
                            PENDIENTE
                        </option>

                        <option value="PAGADO">
                            PAGADO
                        </option>

                        <option value="EN_PREPARACION">
                            EN PREPARACIÓN
                        </option>

                        <option value="ENVIADO">
                            ENVIADO
                        </option>

                        <option value="ENTREGADO">
                            ENTREGADO
                        </option>

                    </select>

                </p>

                <p><strong>Total:</strong> ${pedido.total}</p>

            </div>

            <h3>Productos</h3>

            <div className="tabla-pedidos-wrapper">

                <table className="tabla-pedidos">

                    <thead>

                        <tr>

                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Subtotal</th>

                        </tr>

                    </thead>

                    <tbody>

                        {
                            pedido.lineas.map((linea, index) => (

                                <tr key={index}>

                                    <td>{linea.producto}</td>

                                    <td>{linea.cantidad}</td>

                                    <td>${linea.precioUnitario}</td>

                                    <td>${linea.subtotal}</td>

                                </tr>

                            ))
                        }

                    </tbody>

                </table>

            </div>

        </div>

    );

}