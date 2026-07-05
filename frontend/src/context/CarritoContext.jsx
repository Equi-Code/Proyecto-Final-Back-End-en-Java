import { createContext, useState } from "react";

export const CarritoContext = createContext();

export function CarritoProvider({ children }) {

    const [carrito, setCarrito] = useState([]);

    function agregarProducto(producto) {

        setCarrito(prev => {

            const existe = prev.find(p => p.id === producto.id);

            if (existe) {

                return prev.map(p =>
                    p.id === producto.id
                        ? { ...p, cantidad: p.cantidad + 1 }
                        : p
                );

            }

            return [
                ...prev,
                {
                    ...producto,
                    cantidad: 1
                }
            ];

        });

    }

    function eliminarProducto(id) {

        setCarrito(prev =>
            prev.filter(p => p.id !== id)
        );

    }

    return (

        <CarritoContext.Provider
            value={{
                carrito,
                agregarProducto,
                eliminarProducto
            }}
        >

            {children}

        </CarritoContext.Provider>

    );

}