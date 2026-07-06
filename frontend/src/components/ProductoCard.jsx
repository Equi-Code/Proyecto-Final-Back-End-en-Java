import { Link } from "react-router-dom";
import "../css/ProductoCard.css";
import { useCarrito } from "../hooks/useCarrito";



function ProductoCard({ producto }) {

    const { agregarProducto } = useCarrito();

    return (

        <div className="producto-card">

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
                    onClick={() => agregarProducto(producto)}
                >
                    Agregar al carrito
                </button>

            </div>

        </div>

    );

}

export default ProductoCard;