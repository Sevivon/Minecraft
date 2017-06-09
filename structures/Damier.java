import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
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

			for ( int dx = 0 ; dx < this.largeur ; dx++ )
				for ( int dz = 0 ; dz < this.hauteur ; dz++ )
					pw.printf("setblock ~%d ~ ~%d %s color=%s\n",dx,dz,this.bloc,(dx+dz)%2==0?this.couleur1:this.couleur2);

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