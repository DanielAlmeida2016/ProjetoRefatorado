package projeto.refatorado.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	public static final String NOME_ARQUIVO = "C:" + File.separator + "Inetpub" + File.separator + "wwwroot";
	private PrintWriter arquivo;

	public void abrir(String nome) throws IOException {
		File file = new File(nome);
		FileOutputStream output;

		if (file.exists()) {
			output = new FileOutputStream(file, true);
		} else {
			output = new FileOutputStream(file);
		}
		arquivo = new PrintWriter(output);
	}

	public void escrever(String texto) throws IOException {
		arquivo.println(texto);
		arquivo.flush();
	}

	public void fechar() throws IOException {
		arquivo.close();
	}

}
