import "../css/ProductoCard.css";

function ProductoCard({ producto }) {

    return (

        <div className="producto-card">

            <h3>{producto.nombre}</h3>

            <p className="categoria">
                {producto.categoria}
            </p>

            <p className="precio">
                ${producto.precio}
            </p>

            <p className="stock">

                Stock: {producto.stock}

            </p>

            <button>

                Agregar al carrito

            </button>

        </div>

    );

}

export default ProductoCard;