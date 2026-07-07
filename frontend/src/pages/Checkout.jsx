import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCarrito } from "../hooks/useCarrito";
import { crearPedido } from "../services/pedidoService";

import "../css/Checkout.css";



export default function Checkout() {




    const navigate = useNavigate();

    const {
        vaciarCarrito
    } = useCarrito();

    const [mensaje, setMensaje] = useState("");

    const { carrito, total } = useCarrito();

    const [cliente, setCliente] = useState({
        nombre: "",
        apellido: "",
        email: "",
        telefono: "",
        direccion: "",
        observaciones: ""
    });

    function handleChange(e) {
        setCliente({
            ...cliente,
            [e.target.name]: e.target.value
        });
    }

    // function confirmarCompra() {

    //     // En el próximo paso enviaremos el pedido al backend.
    //     console.log(cliente);
    //     console.log(carrito);

    //     alert("Pedido listo para enviar.");

    // }

    async function confirmarCompra() {

        try {

            const pedido = {

                lineas: carrito.map(item => ({

                    productoId: item.id,
                    cantidad: item.cantidad

                }))

            };

            const respuesta = await crearPedido(pedido);

            vaciarCarrito();

            setMensaje(
                `✅ Pedido #${respuesta.id} creado correctamente`
            );

            setTimeout(() => {

                navigate("/");

            }, 2500);

        } catch (error) {

            console.error(error);

            alert("Ocurrió un error al generar el pedido.");

        }

    }

    return (

        <div className="checkout-container">

            {
                mensaje &&

                <div className="mensaje-exito">

                    {mensaje}

                </div>
            }

            <h1>Finalizar compra</h1>

            <div className="checkout-grid">

                <div className="formulario">

                    <h2>Datos del cliente</h2>

                    <input
                        name="nombre"
                        placeholder="Nombre"
                        value={cliente.nombre}
                        onChange={handleChange}
                    />

                    <input
                        name="apellido"
                        placeholder="Apellido"
                        value={cliente.apellido}
                        onChange={handleChange}
                    />

                    <input
                        name="email"
                        placeholder="Email"
                        value={cliente.email}
                        onChange={handleChange}
                    />

                    <input
                        name="telefono"
                        placeholder="Teléfono"
                        value={cliente.telefono}
                        onChange={handleChange}
                    />

                    <input
                        name="direccion"
                        placeholder="Dirección"
                        value={cliente.direccion}
                        onChange={handleChange}
                    />

                    <textarea
                        name="observaciones"
                        placeholder="Observaciones"
                        value={cliente.observaciones}
                        onChange={handleChange}
                    />

                </div>

                <div className="resumen">

                    <h2>Resumen del pedido</h2>

                    {
                        carrito.map(item => (

                            <div
                                key={item.id}
                                className="item-resumen"
                            >

                                <span>{item.nombre}</span>

                                <span>
                                    {item.cantidad} x ${item.precio}
                                </span>

                            </div>

                        ))
                    }

                    <hr />

                    <h3>Total: ${total}</h3>

                    <div className="acciones-checkout">

                        <button
                            onClick={() => navigate("/carrito")}
                        >
                            Volver
                        </button>

                        <button
                            onClick={confirmarCompra}
                        >
                            Confirmar compra
                        </button>

                    </div>

                </div>

            </div>

        </div>

    );

}
