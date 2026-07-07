import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import { obtenerPedidos } from "../services/pedidoService";
import "../css/Pedidos.css";

export default function Pedidos() {

    const [pedidos, setPedidos] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        async function cargar() {

            const data = await obtenerPedidos();

            setPedidos(data);

            setLoading(false);

        }

        cargar();

    }, []);

    if (loading) {
        return <h2 className="pedidos-cargando">Cargando pedidos...</h2>;
    }

    return (

        <div className="pedidos-container">

            <h2>Historial de pedidos</h2>

            {pedidos.length === 0 ? (

                <p className="pedidos-vacio">Todavía no tenés pedidos realizados.</p>

            ) : (

                <div className="tabla-pedidos-wrapper">

                    <table className="tabla-pedidos">

                        <thead>

                            <tr>

                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Estado</th>
                                <th>Total</th>
                                <th></th>

                            </tr>

                        </thead>

                        <tbody>

                            {
                                pedidos.map(pedido => (

                                    <tr key={pedido.id}>

                                        <td><strong>#{pedido.id}</strong></td>

                                        <td>{pedido.fecha}</td>

                                        <td>
                                            <span className={`badge-estado ${pedido.estado?.toLowerCase()}`}>
                                                {pedido.estado}
                                            </span>
                                        </td>

                                        <td>${pedido.total}</td>

                                        <td>

                                            <Link
                                                to={`/pedidos/${pedido.id}`}
                                            >
                                                Ver detalle
                                            </Link>

                                        </td>

                                    </tr>

                                ))
                            }

                        </tbody>

                    </table>

                </div>

            )}

        </div>

    );

}