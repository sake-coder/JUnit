package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleado {
	Empleado e;

	@Before
	public void before() {

		e = new Empleado();
	}

	@Test
	public void calcularPrimaCorrecto() {
		try {
			e.calcularPrima("333", "Jorge", "013", "-");
		} catch (NumeroEmpleadoException ex) {
			fail("Numero de empleado incorrecto ");
		} catch (NombreEmpleadoException ex) {
			fail("Tipo de nombre incorrecto");
		} catch (MesesTrabajoException ex) {
			fail("Numero de meses incorrecto");
		} catch (CargoException ex) {
			fail("Tipo de cargo incorrecto");
		}

		assertEquals(Prima.P4, e.getPrima());
	}

	@Test
	public void establecerNumeroDeEmpleadoCorrecto() {

		try {
			e.establecerNumeroEmpleado("4");
		} catch (NumeroEmpleadoException ex) {
			fail();
		}
		assertEquals(4, e.getNumeroEmpleado());
	}

	@Test
	public void estableceNombreEmpleadoCorrecto() {
		try {
			e.estableceNombreEmpleado("Manuel");
		} catch (NombreEmpleadoException ex) {
			fail("Tipo de nombre incorrecto");
		}
		assertEquals("Manuel", e.getNombreEmpleado());
	}

	@Test
	public void estableceMesesTrabajoCorrecto() {
		try {
			e.estableceMesesTrabajo("013");
		} catch (MesesTrabajoException ex) {
			fail("Numero de meses incorrecto");
		}
		assertEquals("013", e.getMesesTrabajo());

	}

	@Test
	public void establecerSerDirectivoCorrecto() {
		try {
			e.establecerSerDirectivo("+");
		} catch (CargoException ex) {
			fail("Tipo de cargo incorrecto");
		}
		assertEquals("+", e.getDirectivo());

	}

	@Test(expected = CargoException.class)
	public void cargoIncorrecto() throws CargoException {
		e.establecerSerDirectivo("*");

	}

	@Test(expected = NombreEmpleadoException.class)
	public void NombreIncorrecto() throws NombreEmpleadoException {
		e.estableceNombreEmpleado("Maria_Antonia");

	}

	@Test(expected = NumeroEmpleadoException.class)
	public void NumeroEmpleadoIncorrecto() throws NumeroEmpleadoException {
		e.establecerNumeroEmpleado("12345");

	}

	@Test(expected = MesesTrabajoException.class)
	public void MesesTrabajoIncorrecto() throws MesesTrabajoException {
		e.estableceMesesTrabajo("1498");

	}

}
