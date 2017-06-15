import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Génération d'un damier
 * @author Sevivon
 */
class Damier
{
	private int largeur;
	private int hauteur;

	private String bloc;

	private String couleur1;
	private String couleur2;

	Damier ( int largeur, int hauteur, String bloc, String couleur1, String couleur2 )
	{
		this.largeur  = largeur;
		this.hauteur  = hauteur;
		this.bloc     = bloc;
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
	}

	void genererFonction ( String fichier )
	{
		try
		{
			PrintWriter pw = new PrintWriter(fichier);

			pw.printf("fill ~ ~ ~ ~%d ~ ~%d %s color=%s\n",largeur-1,hauteur-1,bloc,couleur2);

			for ( int dx = 0 ; dx < largeur ; dx++ )
				for ( int dz = dx%2 ; dz < hauteur ; dz+=2 )
					pw.printf("setblock ~%d ~ ~%d %s color=%s\n",dx,dz,bloc,couleur1);

			pw.close();
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
	}

	public static void main ( String... argv )
	{
		Damier echiquier = new Damier(8,8,"concrete","white","black");
		echiquier.genererFonction("fonctions/echiquier.mcfunction");

		Damier damier = new Damier(10,10,"concrete","white","black");
		damier.genererFonction("fonctions/plateau_dames.mcfunction");

		Damier damier50 = new Damier(50,50,"wool","lime","red");
		damier50.genererFonction("fonctions/damier50.mcfunction");
	}
}