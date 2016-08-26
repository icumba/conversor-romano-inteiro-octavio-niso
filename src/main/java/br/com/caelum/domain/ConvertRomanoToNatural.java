package br.com.caelum.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import br.com.caelum.interfaces.ConvertivelParaRomano;

public class ConvertRomanoToNatural implements ConvertivelParaRomano{
	private String[] romanString;
	private HashMap<String, Integer> romanToIntegerMap;
	private Set<Integer> lessIndices ;
	private int numLength;

	public ConvertRomanoToNatural() {
		romanToIntegerMap = new HashMap<String, Integer>();
		romanToIntegerMap.put("I", 1);
		romanToIntegerMap.put("II", 2);
		romanToIntegerMap.put("III", 3);
		romanToIntegerMap.put("IV", 4);
		romanToIntegerMap.put("V", 5);
		romanToIntegerMap.put("VI", 6);
		romanToIntegerMap.put("VII", 7);
		romanToIntegerMap.put("VIII", 8);
		romanToIntegerMap.put("IX", 9);
		romanToIntegerMap.put("X", 10);
		romanToIntegerMap.put("L", 50);
		romanToIntegerMap.put("C", 100);
		romanToIntegerMap.put("D", 500);
		romanToIntegerMap.put("M", 1000);

	}

	@Override
	public int retornaNumeroNatural(String numeroRomano) {
		romanString = numeroRomano.split("");
		numLength = romanString.length;
		devolveListaDeMenoresIndices();
		return getResultado();
	}

	private Set<Integer> devolveListaDeMenoresIndices() {
		lessIndices = new HashSet<Integer>();
		for (int i = 0; i < numLength; ++i) {
			System.out.println("se " + i + 1 + " < totalpPalavra " + numLength);
			if (i + 1 < numLength) {
				System.out.println(i + " = " + romanToIntegerMap.get(romanString[i]) + " < "
						+ romanToIntegerMap.get(romanString[i + 1]));
				if (romanToIntegerMap.get(romanString[i]) < romanToIntegerMap.get(romanString[i + 1])) {
					lessIndices.add(i);
					System.out.println("Introduziu " + i);
				}

			}
		}
		return lessIndices;
	}

	private int getResultado() {
		int num = 0;
		for (int i = 0; i < numLength;) {
			if (!lessIndices.contains(i)) {
				num = num + romanToIntegerMap.get(romanString[i]);
				++i;
			} else {
				num = num + romanToIntegerMap.get(romanString[i + 1]) - romanToIntegerMap.get(romanString[i]);
				i += 2;
			}
		}
		System.out.println("The integer representation of the roman numeral is : " + num);
		return num;

	}
}
