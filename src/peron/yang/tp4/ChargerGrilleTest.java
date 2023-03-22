package peron.yang.tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import peron.yang.tp2.MotsCroises;

public class ChargerGrilleTest {

	public static ChargerGrille cg;
	public static MotsCroises mc;

	@BeforeEach
	public void setUp() throws Exception {
		cg = new ChargerGrille();

	}

	@Test
	public void testGrillesDisponibles() throws SQLException {
		Map<Integer, String> gd;
		gd = cg.grillesDisponibles();
		assertEquals("Français débutants (7x6)", gd.get(10), "Eh, t nul, bouuuuh");
	}

	@Test
	public void testExtraireGrille() throws SQLException {
		mc = cg.extraireGrille(10);
		assertEquals('a', mc.getSolution(1, 1), "Roooh, tu peux faire mieux, t décevant frèr");
		try {
			mc.getSolution(6, 2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
