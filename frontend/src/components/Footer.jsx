import { Link } from "react-router-dom";
import "../css/Footer.css";

export default function Footer() {

    const anio = new Date().getFullYear();

    return (

        <footer className="footer">

            <div className="footer-contenido">

                <h2 className="footer-marca">
                    Código <span>Limpio</span>
                </h2>

                <p className="footer-descripcion">
                    Tu tienda online de artículos deportivos desarrollada con React, Spring Boot y MySQL.
                </p>

                <ul className="footer-links">

                    <li>
                        <Link to="/">Inicio</Link>
                    </li>

                    <li>
                        <Link to="/categoria/indumentaria">
                            Indumentaria
                        </Link>
                    </li>

                    <li>
                        <Link to="/categoria/accesorios">
                            Accesorios
                        </Link>
                    </li>

                    <li>
                        <Link to="/pedidos">
                            Pedidos
                        </Link>
                    </li>

                </ul>

                <hr />
                <p className="footer-copy">
                    © {anio} Código Limpio. Todos los derechos reservados.
                </p>

                <p className="footer-dev">
                    Desarrollado por <strong>Ezequiel Riente</strong>
                </p>

            </div>

        </footer>

    );

}