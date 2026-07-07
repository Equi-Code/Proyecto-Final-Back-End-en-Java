import { useEffect, useState, useContext } from "react";
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

    if (loading) {
        return <h2>Cargando producto...</h2>;
    }

    if (!producto) {
        return <h2>Producto no encontrado.</h2>;
    }

    return (

        <div className="detalle-container">

            <h1>{producto.nombre}</h1>

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
                    <strong>Stock:</strong> {producto.stock}
                </p>

            </div>

            <div className="botones">

                <button
                    onClick={() => {
                        agregarProducto(producto);
                        alert("✅ Producto agregado al carrito.");
                    }}
                >
                    Agregar al carrito
                </button>
                
                <button
                    onClick={() => navigate(-1)}
                >
                    Volver
                </button>

            </div>

        </div>

    );

}