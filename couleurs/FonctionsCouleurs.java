import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Génération, pour chaque bloc considéré, d'une fonction Minecraft donnant au joueur une unité de chaque couleur de ce bloc
 * Uniquement pour Minecraft 1.12
 * Voir la vidéo du 8 juin 2017 : https://www.youtube.com/watch?v=5oMPv52e7HA
 * @author Sevivon
 */
class FonctionsCouleurs
{
	static final String[] BLOCS1   = {"wool","stained_hardened_clay","stained_glass","concrete","concrete_powder","bed","banner"};
	static final String[] BLOCS2   = {"glazed_terracotta","shulker_box"};
	static final String[] COULEURS = {"white","orange","magenta","light_blue","yellow","lime","pink","gray","silver","cyan","purple","blue","brown","green","red","black"};

	public static void main (String... argv) 
	{
		try
		{
			PrintWriter pw;

			for ( String bloc : BLOCS1 )
			{
				pw = new PrintWriter("colors/"+bloc+".mcfunction");
				pw.println("clear @p");

				for ( int i = 0 ; i < COULEURS.length ; i++ )
					pw.println("give @p "+bloc+" 1 "+i);

				pw.close();
			}

			for ( String bloc : BLOCS2 )
			{
				pw = new PrintWriter("colors/"+bloc+".mcfunction");
				pw.println("clear @p");

				for ( String couleur : COULEURS )
					pw.println("give @p "+couleur+"_"+bloc+" 1 0");

				pw.close();
			}
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
	}
}