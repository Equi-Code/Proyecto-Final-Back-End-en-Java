import { useNavigate } from "react-router-dom";

export default function Checkout() {

    const navigate = useNavigate();

    return (

        <div className="container">

            <h2>Finalizar compra</h2>

            <p>Resumen del pedido</p>

            <button>
                Confirmar compra
            </button>

            <button
                onClick={() => navigate("/carrito")}
            >
                Volver al carrito
            </button>

        </div>

    );

}
