package br.thiagojacinto.sefazpe.negocio;

import java.util.List;

public class Utilidades {

	// Métodos

	// Criar item na lista `telefones` com cada `ddd` + `número`
	public static void adicionarTelefone(List<String> lista, Integer DDD, String numero, String tipo) {

		// Formatando a String com a seguinte ordem "0" + DDD + numero + "," + tipo:
		String adicionar = String.format("0%d %s,%s", DDD, numero, tipo);

		lista.add(adicionar);
	}

}
