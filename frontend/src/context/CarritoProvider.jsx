import { useState } from "react";
import CarritoContext from "./CarritoContext";

export function CarritoProvider({ children }) {

    const [carrito, setCarrito] = useState([]);

    function agregarProducto(producto) {

        const existe = carrito.find(p => p.id === producto.id);

        if (existe) {

            if (existe.cantidad >= producto.stock) {
                alert("No hay más stock disponible.");
                return;
            }

            setCarrito(
                carrito.map(p =>
                    p.id === producto.id
                        ? { ...p, cantidad: p.cantidad + 1 }
                        : p
                )
            );

        } else {

            setCarrito([
                ...carrito,
                {
                    ...producto,
                    cantidad: 1
                }
            ]);

        }
    }

    function eliminarProducto(id) {

        setCarrito(
            carrito.filter(p => p.id !== id)
        );

    }

    function aumentarCantidad(id) {

        setCarrito(
            carrito.map(p => {

                if (p.id !== id)
                    return p;

                if (p.cantidad >= p.stock) {
                    alert("No hay más stock disponible.");
                    return p;
                }

                return {
                    ...p,
                    cantidad: p.cantidad + 1
                };
            })
        );
    }

    function disminuirCantidad(id) {

        setCarrito(
            carrito
                .map(p =>
                    p.id === id
                        ? { ...p, cantidad: p.cantidad - 1 }
                        : p
                )
                .filter(p => p.cantidad > 0)
        );

    }

    function vaciarCarrito() {

    setCarrito([]);

}

    const total = carrito.reduce(
        (acum, item) => acum + item.precio * item.cantidad,
        0
    );

    return (

        <CarritoContext.Provider
            value={{
                carrito,
                agregarProducto,
                eliminarProducto,
                aumentarCantidad,
                disminuirCantidad,
                vaciarCarrito,
                total
            }} 
        >
            {children}
        </CarritoContext.Provider>

    );
}

