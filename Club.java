import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Almacena los miembros del club
    ArrayList<Membership> miembros;

    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        miembros = new ArrayList<Membership>();

    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        miembros.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return miembros.size();
    }

    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int month)
    {
        int contadorSocios = 0;
        // Primero comprobamos que el parametro sea valido
        if ((month >= 1) && (month <= 12))
        {
            // Recorremos la lista de miembros, si alguno coincide con el mes, sumamos uno al contador
            for (Membership member : miembros)
            {
                if (member.getMonth() == month)
                {
                    contadorSocios++;
                }
            }
        }
        else
        {
            System.out.println ("El mes introducido no es un valor valido");
        }
        return contadorSocios;
    }

    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList<Membership> purge(int month, int year)
    {
        // hacemos una lista de miembros
        ArrayList<Membership> purgados = new ArrayList<Membership>();
        // Primero comprobamos que el parametro sea valido
        if ((month >= 1) && (month <= 12))
        {
            // Usando un bucle while, comprobamos si se corresponde el miembro
            // con el mes y año a dar de baja, si no es asi lo borramos
            Iterator<Membership> it = miembros.iterator();
            while (it.hasNext())
            {
                Membership miembro = it.next();
                it.remove();
                // Si coincide, lo borramos y guardamos en la arraylist purgados
                if (miembro.getMonth() == month && miembro.getYear() == year)
                {
                    purgados.add(miembro);
                    miembros.remove(miembro);
                }
            }
        }
        else
        {
            System.out.println ("El mes introducido no es un valor valido");
        }
        return purgados;
    }

}
