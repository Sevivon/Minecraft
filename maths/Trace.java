import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.DoubleFunction;

/**
 * Tracé d'une fonction mathématique sur Minecraft
 * @author Sevivon
 */
class Trace
{
	private static final String BLOC_TRACE    = "concrete";
	private static final String COULEUR_TRACE = "black";

	private DoubleFunction<Double> fonction;

	private int xMin;
	private int xMax;

	private int echelleX; // nombre de blocs pour une unité en x
	private int echelleY; // nombre de blocs pour une unité en y

	Trace ( DoubleFunction<Double> fonction, int xMin, int xMax, int echelleX, int echelleY )
	{
		this.fonction = fonction;
		this.xMin     = xMin;
		this.xMax     = xMax<xMin?xMin:xMax;
		this.echelleX = echelleX<1?1:echelleX;
		this.echelleY = echelleY<1?1:echelleY;
	}

	void genererFonction ( String fichier )
	{
		try
		{
			PrintWriter pw = new PrintWriter(fichier);
			int x, y;

			for ( x = 0 ; x <= echelleX*(xMax-xMin) ; x++ )
			{
				y = (int)Math.round(echelleY*fonction.apply(xMin+(double)x/echelleX));
				pw.printf("setblock ~%d ~ ~%d %s color=%s\n",x,y,BLOC_TRACE,COULEUR_TRACE);
			}
			
			pw.close();
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
	}

	public static void main ( String... argv )
	{
		Trace traceCarre = new Trace(x->x*x,0,10,10,10);
		traceCarre.genererFonction("fonctions/traceCarre.mcfunction");
	}
}