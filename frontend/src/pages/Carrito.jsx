import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useCarrito } from "../hooks/useCarrito";

import "../css/Carrito.css";

export default function Carrito() {
    const navigate = useNavigate();

    const {
        carrito,
        aumentarCantidad,
        disminuirCantidad,
        eliminarProducto,
        vaciarCarrito,
        total
    } = useCarrito();

    if (carrito.length === 0) {

        return (

            <div className="carrito-vacio">

                <h2>🛒 Tu carrito está vacío</h2>

                <Link to="/" className="btn-volver">
                    Ir a comprar
                </Link>

            </div>

        );

    }

    return (

        <div className="carrito-container">

            <h1>Carrito de compras</h1>

            {carrito.map(producto => (

                <div
                    className="item-carrito"
                    key={producto.id}
                >

                    <div>

                        <h3>{producto.nombre}</h3>

                        <p>Precio: ${producto.precio}</p>

                        <p>
                            Subtotal:
                            ${producto.precio * producto.cantidad}
                        </p>

                    </div>

                    <div className="acciones-carrito">

                        <button
                            className="btn-cantidad"
                            onClick={() => disminuirCantidad(producto.id)}
                        >
                            −
                        </button>

                        <span className="cantidad-valor">{producto.cantidad}</span>

                        <button
                            className="btn-cantidad"
                            onClick={() => aumentarCantidad(producto.id)}
                        >
                            +
                        </button>

                        <button
                            className="eliminar"
                            onClick={() => eliminarProducto(producto.id)}
                        >
                            Eliminar
                        </button>

                    </div>

                </div>

            ))}

            <div className="resumen">

                <h2>Total: ${total}</h2>

            </div>

            <div className="acciones-finales">

                <button
                    className="vaciar"
                    onClick={vaciarCarrito}
                >
                    Vaciar carrito
                </button>

                <button className="btn-seguir"
                    onClick={() => navigate("/")}
                >
                    Seguir comprando
                </button>

                <button className="btn-finalizar" onClick={() => navigate("/checkout")}>

                    Finalizar compra

                </button>

            </div>

        </div>

    );

}