package org.mql.biblio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.mql.biblio.models.Author;

public class Test {

	public Test() {
		exp02();
	}

	public void exp01() {
		Author a = new Author(101, "James Gosling", 1956);
		try {
			OutputStream os = new FileOutputStream("resources/Authors.dat");
			ObjectOutputStream out = new ObjectOutputStream(os);
			out.writeObject(a);
			out.close();
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void exp02() {
		Author a ;
		try {
			InputStream is = new FileInputStream("resources/Authors.dat");
			ObjectInputStream in = new ObjectInputStream(is);
			// Déserialisation
			a = (Author)in.readObject();
			System.out.println(a);
			in.close();
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
