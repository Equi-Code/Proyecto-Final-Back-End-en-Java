import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
import "../css/ProductoCard.css";
import { useCarrito } from "../hooks/useCarrito";

function ProductoCard({ producto }) {

    const { agregarProducto } = useCarrito();

    const [mensaje, setMensaje] = useState("");
    const timeoutRef = useRef(null);

    // Limpia el timeout si el componente se desmonta antes de que termine
    useEffect(() => {
        return () => clearTimeout(timeoutRef.current);
    }, []);

    function handleAgregar() {

        agregarProducto(producto);
        setMensaje("✅ Producto agregado al carrito");

        clearTimeout(timeoutRef.current);
        timeoutRef.current = setTimeout(() => {
            setMensaje("");
        }, 2000);

    }

    return (

        <div className="producto-card">

            {
                mensaje &&

                <div className="mensaje-carrito">
                    {mensaje}
                </div>
            }

            <h3>{producto.nombre}</h3>

            <p className="precio">
                ${producto.precio}
            </p>

            <p className="stock">
                Stock: {producto.stock}
            </p>

            <div className="acciones">

                <Link
                    className="btn-detalle"
                    to={`/producto/${producto.id}`}
                >
                    Ver detalle
                </Link>

                <button
                    className="carrito"
                    onClick={handleAgregar}
                >
                    Agregar al carrito
                </button>

            </div>

        </div>

    );

}

export default ProductoCard;