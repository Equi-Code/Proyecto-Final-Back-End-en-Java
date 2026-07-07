import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { obtenerProductos } from "../services/productoService";
import ProductoCard from "../components/ProductoCard";
import "../css/Home.css";

export default function Categoria() {
    const { categoria } = useParams();

    const [productos, setProductos] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function cargarProductos() {
            try {
                const data = await obtenerProductos();

                // Filtra por categoría, ignorando mayúsculas/minúsculas
                const filtrados = data.filter(
                    (producto) =>
                        producto.categoria?.toLowerCase() === categoria.toLowerCase()
                );

                setProductos(filtrados);
            } catch (error) {
                console.error(error);
            } finally {
                setLoading(false);
            }
        }

        cargarProductos();
    }, [categoria]); // se vuelve a ejecutar si cambia la categoría en la URL

    if (loading) {
        return <h2>Cargando productos...</h2>;
    }

    const titulo = categoria.charAt(0).toUpperCase() + categoria.slice(1);

    return (
        <div className="home">
            <h1>{titulo}</h1>

            {productos.length === 0 ? (
                <p style={{ textAlign: "center" }}>
                    No hay productos disponibles en esta categoría.
                </p>
            ) : (
                <div className="productos-grid">
                    {productos.map((producto) => (
                        <ProductoCard key={producto.id} producto={producto} />
                    ))}
                </div>
            )}
        </div>
    );
}