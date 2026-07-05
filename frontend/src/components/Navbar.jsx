import { Link } from "react-router-dom";
import "../css/navbar.css";

function Navbar() {
    return (
        <nav className="navbar">

            <h2 className="logo">Código Limpio</h2>

            <ul className="menu">

                <li>
                    <Link to="/">Inicio</Link>
                </li>

                <li>
                    <Link to="/indumentaria">Indumentaria</Link>
                </li>

                <li>
                    <Link to="/accesorios">Accesorios</Link>
                </li>

                <li>
                    <Link to="/carrito">🛒 Carrito</Link>
                </li>

            </ul>

        </nav>
    );
}

export default Navbar;