import { useEffect, useState } from "react";
import { obtenerProductos } from "../services/productoService";
import ProductoCard from "../components/ProductoCard";
import "../css/Home.css";

export default function Home() {
    const [productos, setProductos] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        // Al definirla dentro del efecto, ESLint sabe exactamente que la actualización
        // de estados (setProductos y setLoading) ocurrirá de manera asíncrona y segura.
        async function cargarProductos() {
            try {
                const data = await obtenerProductos();
                setProductos(data);
            } catch (error) {
                console.error(error);
            } finally {
                setLoading(false);
            }
        }

        cargarProductos();
    }, []); // Array de dependencias vacío para que solo se ejecute al montar el componente

    if (loading) {
        return <h2>Cargando productos...</h2>;
    }

    return (
        <div className="home">
            <h1>Tienda Deportiva</h1>

            <div className="productos-grid">
                {productos.map((producto) => (
                    <ProductoCard
                        key={producto.id}
                        producto={producto}
                    />
                ))}
            </div>
        </div>
    );
}