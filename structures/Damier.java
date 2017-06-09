import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Sevivon
 */
class Damier
{
	private int largeur;
	private int hauteur;

	private String couleur1;
	private String couleur2;

	Damier ( int largeur, int hauteur, String couleur1, String couleur2 )
	{
		this.largeur  = largeur;
		this.hauteur  = hauteur;
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
					pw.println(String.format("setblock ~%d ~ ~%d wool color=%s",dx,dz,(dx+dz)%2==0?this.couleur1:this.couleur2));

			pw.close();
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
	}

	public static void main ( String... argv )
	{
		Damier echiquier = new Damier(8,8,"white","black");
		echiquier.genererFonction("fonctions/echiquier.mcfunction");

		Damier damier = new Damier(10,10,"white","black");
		damier.genererFonction("fonctions/plateauDames.mcfunction");

		Damier damier50 = new Damier(50,50,"lime","red");
		damier50.genererFonction("fonctions/damier50.mcfunction");
	}
}