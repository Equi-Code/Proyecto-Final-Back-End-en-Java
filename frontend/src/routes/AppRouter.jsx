import { BrowserRouter, Routes, Route } from "react-router-dom";

import MainLayout from "../layout/MainLayout";

import Home from "../pages/Home";
import Accesorios from "../pages/Accesorios";
import Indumentaria from "../pages/Indumentaria";
import Carrito from "../pages/Carrito";
import Checkout from "../pages/Checkout";
import NotFound from "../pages/NotFound";
import DetalleProducto from "../pages/DetalleProducto";

export default function AppRouter() {

    return (

        <BrowserRouter>

            <MainLayout>

                <Routes>

                    <Route path="/" element={<Home />} />

                    <Route path="/accesorios" element={<Accesorios />} />

                    <Route path="/indumentaria" element={<Indumentaria />} />

                    <Route path="/carrito" element={<Carrito />} />

                    <Route path="/checkout" element={<Checkout />} />

                    <Route path="*" element={<NotFound />} />

                    <Route
                        path="/producto/:id"
                        element={<DetalleProducto />}
                    />
                </Routes>
            </MainLayout>

        </BrowserRouter>

    );

}