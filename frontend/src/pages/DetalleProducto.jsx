import { useEffect, useRef, useState, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";

import { obtenerProducto } from "../services/productoService";
import CarritoContext from "../context/CarritoContext";

import "../css/DetalleProducto.css";

export default function DetalleProducto() {

    const { id } = useParams();
    const navigate = useNavigate();

    const { agregarProducto } = useContext(CarritoContext);

    const [producto, setProducto] = useState(null);
    const [loading, setLoading] = useState(true);
    const [mensaje, setMensaje] = useState("");
    const timeoutRef = useRef(null);

    useEffect(() => {

        async function cargarProducto() {

            try {

                const data = await obtenerProducto(id);
                setProducto(data);

            } catch (error) {

                console.error(error);

            } finally {

                setLoading(false);

            }

        }

        cargarProducto();

    }, [id]);

    // Limpia el timeout del mensaje si el usuario navega antes de que termine
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

    if (loading) {
        return <h2>Cargando producto...</h2>;
    }

    if (!producto) {
        return <h2>Producto no encontrado.</h2>;
    }

    const sinStock = producto.stock <= 0;

    return (

        <div className="detalle-container">

            {
                mensaje &&
                <div className="mensaje-exito">
                    {mensaje}
                </div>
            }

            <h1>{producto.nombre}</h1>

            <img
                src={
                    producto.imagenUrl ||
                    "https://placehold.co/700x500?text=Sin+Imagen"
                }
                alt={producto.nombre}
                className="detalle-imagen"
            />

            <p className="detalle-descripcion">
                {producto.descripcion}
            </p>


           <div className="detalle-info">

                <p>
                    <strong>Categoría:</strong> {producto.categoria}
                </p>

                {
                    producto.tipo &&
                    <p>
                        <strong>Tipo:</strong> {producto.tipo}
                    </p>
                }

                {
                    producto.marca &&
                    <p>
                        <strong>Marca:</strong> {producto.marca}
                    </p>
                }

                {
                    producto.talle &&
                    <p>
                        <strong>Talle:</strong> {producto.talle}
                    </p>
                }

                <p>
                    <strong>Precio:</strong> ${producto.precio}
                </p>

                <p>
                    <strong>Stock:</strong>{" "}
                    {sinStock ? (
                        <span className="sin-stock">Sin stock</span>
                    ) : (
                        producto.stock
                    )}
                </p>

            </div>

            <div className="botones">

                <button
                    className="btn-agregar"
                    onClick={handleAgregar}
                    disabled={sinStock}
                >
                    {sinStock ? "Sin stock" : "Agregar al carrito"}
                </button>

                <button
                    className="btn-secundario"
                    onClick={() => navigate(-1)}
                >
                    Volver
                </button>

            </div>

        </div>

    );

}