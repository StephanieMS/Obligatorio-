package uy.edu.um.prog2.adt.hash;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestHashCerrado {

	@Test
	public void test() {
		HashTable<Integer, String> hC = new HashCerrado<>(4);

		try {
			hC.insertar(1, "A");
			hC.insertar(2, "B");
			hC.insertar(3, "C");
			hC.insertar(4, "D");
		} catch (ElementoYaExistenteException e) {
			fail("ElementoYaExistenteException");
		}

		assertTrue(hC.pertenece(1));

		try {
			hC.borrar(3);
		} catch (ClaveInvalida e1) {
			fail("ClaveInvalida");
		}
		assertFalse(hC.pertenece(3));

		try {
			hC.insertar(3, "H");
		} catch (ElementoYaExistenteException e) {
			fail("ElementoYaExistenteException");
		}
	}
}
