
 
// Statistik.java

public class Statistik
{
//  Symbolische Namen waren bis Java 5 der Standard
//	Seit Java 5 verwendet man hï¿½ufig enum
	
//	public static final int ARITHMETISCH = 0;
//	public static final int GEOMETRISCH = 1;
//	public static final int HARMONISCH = 2;
	
//	public enum Mittelwert
//	{
//		ARITHMETISCH,
//		GEOMETRISCH,
//		HARMONISCH
//	}
	
	public static double berechneMittelwert(double[] zahlen, MittelwertTyp art)
				throws MittelwertException
	{
		double sum=0.0, prod=1.0, suminvers=0.0,mw=0.0;
		if(zahlen==null)
		{
			throw new MittelwertException("Berechnung Mittelwert: Zahlenarray ist null!");
			
		}
		int anzahl=zahlen.length;
		
		if( anzahl<=0)
		{
			throw new MittelwertException("Berechnung Mittelwert: Keine Zahlen Ã¼bergeben!");
		}
		
		switch(art)
		{
			case ARITHMETISCH:
				mw=0.0;
				for(int i=0; i<anzahl; i++)
				{
					sum=sum+zahlen[i];
				}
				mw=sum/anzahl;
				break;
				
			case GEOMETRISCH:
//				mw=1.0;
				for(int i=0; i<anzahl; i++)
				{
					if( zahlen[i]<=0)
					{
						throw new MittelwertException("Geometrischer Mittelwert: Alle Zahlen müssen positiv sein!");						
					}
					prod=prod*zahlen[i];
				}
				mw=Math.pow(prod,1.0/anzahl);
				break;
				
			case HARMONISCH:
				mw=1.0;
				for(int i=0; i<anzahl; i++)
				{
					if( zahlen[i]==0)
					{
						throw new MittelwertException("Harmonischer Mittelwert: Zahlen dürfen nicht 0 sein!");						
					}
					suminvers=suminvers+1.0/zahlen[i];
				}
				mw=anzahl/suminvers;
				break;
		}
		return mw;	
	}
}	

