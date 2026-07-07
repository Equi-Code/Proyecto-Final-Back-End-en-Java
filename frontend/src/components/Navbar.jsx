import { Link } from "react-router-dom";
import "../css/navbar.css";
import { useCarrito } from "../hooks/useCarrito";


function Navbar() {

    const { carrito } = useCarrito();

    const cantidad = carrito.reduce(
        (total, item) => total + item.cantidad,
        0
    );

    return (
        <nav className="navbar">

            <h2 className="logo">Código Limpio</h2>

            <ul className="menu">

                <li>
                    <Link to="/">Inicio</Link>
                </li>

                <Link to="/categoria/indumentaria">Indumentaria</Link>
                <Link to="/categoria/accesorios">Accesorios</Link>


                <li>
                    <Link to="/pedidos">
                        Pedidos
                    </Link>
                </li>

                <li>



                    <Link
                        to="/carrito"
                        className="carrito-link"
                    >

                        🛒 Carrito

                        {
                            cantidad > 0 &&
                            <span className="badge-carrito">
                                ({cantidad})
                            </span>
                        }

                    </Link>

                </li>

            </ul>

        </nav>
    );
}

export default Navbar;