package b.orrar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

 class HuespedTest {
    
    @Test
     void equals(){
        // Arrange
		int id = 1;
		String nombre = "José";
		Reserva reserva1 = new Reserva();
		Reserva reserva2 = new Reserva();
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(reserva1);
		reservas.add(reserva2);

		// Act
		Huesped huesped = new Huesped();
		huesped.setId(id);
		huesped.setName(nombre);
        huesped.setReservas(reservas);

		// Assert
		assertEquals(id, huesped.getId());
		assertEquals(nombre, huesped.getName());
		assertEquals(reservas, huesped.getReservas());
    }
}
