package br.com.caelum.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.domain.ConvertRomanoToNatural;

public class ConvertRomanoToNaturalTest {

	@Test
	public void deveRetornar10() {
		ConvertRomanoToNatural convertRomanoToNatural = new ConvertRomanoToNatural();
		assertEquals(10, convertRomanoToNatural.retornaNumeroNatural("X")); 
	}

}
