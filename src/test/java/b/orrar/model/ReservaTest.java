package b.orrar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

 class ReservaTest {
    
    @Test
     void equals(){

        // Arrange
		final int id = 1;
		final LocalDateTime date = LocalDateTime.now();

		// Act
		Reserva reserva = new Reserva();
		reserva.setId(id);
        reserva.setDate(date);

		// Assert
		assertEquals(id, reserva.getId());
		assertEquals(date, reserva.getDate());
    }
}
