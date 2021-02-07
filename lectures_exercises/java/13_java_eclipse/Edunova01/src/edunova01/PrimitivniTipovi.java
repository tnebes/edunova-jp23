package edunova01;

import javax.swing.JOptionPane;

public class PrimitivniTipovi {
		public static void main(String[] args) {
			String unioKorisnik = JOptionPane.showInputDialog("Unesi broj");
			int i = Integer.parseInt(unioKorisnik);
			
			System.out.println(i);
			
			boolean b = Boolean.parseBoolean("true");
			char c = Character.forDigit(23,	16);
			System.out.println(c);
			
			//cijeli brojevi
			byte by=Byte.parseByte("12");
			short s=Short.parseShort("2");
			long l=Long.parseLong("12");
			
			//decimlani broj
			float f=Float.parseFloat("12.99");
			System.out.println(f);
			double d=Double.parseDouble("12.99");
			System.out.println(f);
		}
}
