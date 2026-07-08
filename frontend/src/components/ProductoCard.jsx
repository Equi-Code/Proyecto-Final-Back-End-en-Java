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


            <img
                src={
                    producto.imagenUrl ||
                    "https://placehold.co/400x300?text=Sin+Imagen"
                }
                alt={producto.nombre}
                className="producto-imagen"
            />

            <h3>{producto.nombre}</h3>

            <p className="descripcion">
                {producto.descripcion}
            </p>

            <p className="categoria">

                {producto.categoria}

            </p>



            <p className="precio">
                ${producto.precio}
            </p>

            <p
                className={
                    producto.stock > 0
                        ? "stock"
                        : "sin-stock"
                }
            >

                {
                    producto.stock > 0

                        ? `Stock disponible: ${producto.stock}`

                        : "❌ Sin stock"

                }

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
                    disabled={producto.stock <= 0}
                >
                    Agregar al carrito
                </button>

            </div>

        </div>

    );

}

export default ProductoCard;