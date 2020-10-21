package br.com.giovani.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.giovani.auxiliary.SortingObjects;
import br.com.giovani.objects.TableFile;

public class FileConfig {

	public FileConfig() {}

	public static  List<String> returnFile(String filePath) {
		List<String> file = null;
		try {
			file = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String[] separeteByColumns(String line) {
		String[] lineBroken = line.split(";");
		return lineBroken;
	}

	public ArrayList<TableFile> addFileLinesToArray(String filePath)  {
		ArrayList<TableFile> fileLines = new ArrayList<TableFile>();
		TableFile tl;
		
		for (int i = 0; i < returnFile(filePath).size(); i++) {
			String[] a = separeteByColumns(returnFile(filePath).get(i));
			tl = new TableFile();
			
			//adicionar as informações de cada campo do arquivo para cada atributo do objeto tl do tipo TableFile
			tl.setName(a[0].trim());
			tl.setLastname(a[1].trim());
			tl.setAge(a[2].trim());
			
			fileLines.add(tl);
		}
		
		fileLines.sort(new SortingObjects());
		return fileLines;
	}
}
