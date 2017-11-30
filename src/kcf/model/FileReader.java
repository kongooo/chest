package kcf.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader br;
	private String line;
	private ArrayList<String> lines;

	public FileReader() throws Exception {
		lines = new ArrayList<String>();
		try {
			fis = new FileInputStream("resource/data.csv");
			isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			br.readLine();
			br.readLine();
			while ((this.line = br.readLine()) != null) {
				lines.add(line);
			}
			fis.close();
			isr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getLines() {
		return lines;
	}
}
